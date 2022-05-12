using HtmlAgilityPack;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Web;


namespace WebCrawler
{
    public partial class frmMain : Form
    {
        const string FILE_PATH_WEBSITES = "Config/Websites.txt";
        const string FILE_PATH_REPLACEMENT_RULES = "Config/ReplacementRules.txt";
        private ArrayList arr = new ArrayList();
        bool isFirstRecord = true;
        string strCrawlDate = "";


        private Dictionary<string, string[]> replacementRules = new Dictionary<string, string[]>();


        public frmMain()
        {
            InitializeComponent();
        }
        private void performReplacement()
        {
            ArrayList arrOriginalLinks = new ArrayList();
            string[] arrReplacedLinks = new string[txtProductPrice.Lines.Length];
            string replacedLink = "";
            string tmpValue;
            for (int i = 0; i < txtProductPrice.Lines.Length; i++)
            {
                replacedLink = txtProductPrice.Lines[i] + "|";
                foreach (KeyValuePair<string, string[]> ruleEntry in replacementRules)
                {
                    // do something with entry.Value or entry.Key

                    arrOriginalLinks.Add(txtProductPrice.Lines[i]);

                    string[] newValue = ruleEntry.Value;

                    for (int j = 0; j < newValue.Length; j++)
                    {
                        tmpValue = txtProductPrice.Lines[i];
                        if (tmpValue.Contains(ruleEntry.Key))
                        {
                            tmpValue = tmpValue.Replace(ruleEntry.Key, newValue[j]);
                            replacedLink = replacedLink + tmpValue + "|";
                        }
                    }

                }
                arrReplacedLinks[i] = replacedLink;
            }
            File.WriteAllLines("Data/ReplacedLink.txt", arrReplacedLinks);

        }

        private void updateReplacementRules()
        {
            replacementRules.Clear();
            string[] rules = File.ReadAllLines(FILE_PATH_REPLACEMENT_RULES);
            string[] tmpResult;
            string[] tmpArr;
            string[] strDelimiter;
            for (int i = 0; i < rules.Length; i++)
            {
                if (rules[i].Contains("|"))
                {
                    strDelimiter = new string[] { "|" };
                    tmpResult = rules[i].Split(strDelimiter, StringSplitOptions.None);
                    //The elements from index 1 will be cloned to create a new array
                    tmpArr = new string[tmpResult.Length - 1];
                    Array.Copy(tmpResult, 1, tmpArr, 0, tmpResult.Length - 1);
                    replacementRules.Add(tmpResult[0], tmpArr);
                }
            }
        }
        private List<string> getWebsiteLinks(string strIndexPage)
        {
            var htmlData = new System.Net.WebClient().DownloadData(strIndexPage);
            var htmlContent = Encoding.UTF8.GetString(htmlData);
            HtmlAgilityPack.HtmlDocument doc = new HtmlAgilityPack.HtmlDocument();
            doc.LoadHtml(htmlContent);
            List<string> listWebsites = new List<string>();

            var links = doc.DocumentNode
           .Descendants("a").Where
           (x => x.Attributes["class"] != null && x.Attributes["class"].Value.Contains("item item--category"));
            foreach (HtmlNode link in links)
            {
                listWebsites.Add(link.Attributes["href"].Value);
            }
            return listWebsites;
        }

        private void Crawl(string strWebsite)
        {

            var htmlData = new System.Net.WebClient().DownloadData(strWebsite);
            var htmlContent = Encoding.UTF8.GetString(htmlData);

            //string htmlContent = new System.Net.WebClient().DownloadString(strWebsite);


            HtmlAgilityPack.HtmlDocument doc = new HtmlAgilityPack.HtmlDocument();
            string strSQLCommand = "";


            doc.LoadHtml(htmlContent);

            string strProductDes = "";
            int intPrice = 0;

            if (htmlContent.IndexOf("data-seller-product-id") >= 0)
            {
                //Do trang web tiki.vn gần đây có thay đổi nên khi crawl thì không dùng đoạn code này
                //mà chương trình sẽ sử dụng đoạn code ở phần else
                var links = doc.DocumentNode
               .Descendants("div").Where
               (x => x.Attributes["data-seller-product-id"] != null && x.Attributes["data-id"] != null && x.Attributes["data-price"] != null
                        && x.Attributes["class"].Value.Contains("product-item"));
                foreach (HtmlNode link in links)
                {
                    HtmlAttribute att_id = link.Attributes["data-id"];
                    HtmlAttribute att_price = link.Attributes["data-price"];
                    HtmlAttribute att_title = link.Attributes["data-title"];

                    strProductDes = att_title.Value;
                    strProductDes = strProductDes.Replace("'", "");
                    txtProductID.AppendText(att_id.Value + Environment.NewLine);
                    txtProductPrice.AppendText(att_price.Value + Environment.NewLine);
                    txtProductDesc.AppendText(strProductDes + Environment.NewLine);

                    if (isFirstRecord == true)
                    {


                        strSQLCommand = "select '" + strCrawlDate + "' CrawlDate,'" + att_id.Value + "' ProductID,'" + strProductDes + "' ProductDesc,'" + att_price.Value + "' Price from dual";
                        isFirstRecord = false;

                    }
                    else
                        strSQLCommand = "union select '" + strCrawlDate + "' CrawlDate,'" + att_id.Value + "' ProductID,'" + strProductDes + "' ProductDesc,'" + att_price.Value + "' Price from dual";

                    txtSQLCommand.AppendText(strSQLCommand + Environment.NewLine);
                    var href = link
                      .Descendants("a").Where
                      (x => x.Attributes["data-id"] != null && x.Attributes["href"] != null);
                    foreach (HtmlNode productLink in href)
                    {
                        HtmlAttribute att_link = productLink.Attributes["href"];
                        txtProductLink.AppendText("https://tiki.vn" + att_link.Value + Environment.NewLine);
                    }

                }

            }
            else
            {
                //Đoạn code mới được cập nhật để crawl do trang tiki.vn có thay đổi gần đây
                var divs = doc.DocumentNode.Descendants("div").Where(x => x.Attributes["class"] != null && x.Attributes["class"].Value.Contains("ProductList"));
                // var links = doc.DocumentNode.Descendants("a").Where(x => x.Attributes["class"] != null && x.Attributes["class"].Value.Contains("product-item"));
                foreach (HtmlNode div in divs)
                {
                    var links = div.Descendants("a").Where
                        (x => x.Attributes["class"] != null && x.Attributes["class"].Value == "product-item");
                    foreach (HtmlNode link in links)
                    {
                        HtmlAttribute att_link = link.Attributes["href"];

                        txtProductLink.AppendText("https://tiki.vn" + att_link.Value + Environment.NewLine);
                        string[] partsLink = att_link.Value.Split('-');
                        string productID = partsLink[partsLink.Length - 1];
                        string[] tmp = productID.Split('.');
                        productID = tmp[0].Substring(1);
                        var productnames = link.Descendants("div").Where
                             (x => x.Attributes["class"] != null && x.Attributes["class"].Value == "name");
                        foreach (HtmlNode productname in productnames)
                            strProductDes = productname.InnerText;
                        var productprices = link.Descendants("div").Where
                            (x => x.Attributes["class"] != null && x.Attributes["class"].Value == "price-discount__price");
                        foreach (HtmlNode productprice in productprices)
                            intPrice = extractNumberFromString(productprice.InnerText);
                        //HtmlAttribute att_price = link.Attributes["data-price"];



                        strProductDes = strProductDes.Replace("'", "");
                        txtProductID.AppendText(productID + Environment.NewLine);
                        txtProductPrice.AppendText(intPrice.ToString() + Environment.NewLine);
                        txtProductDesc.AppendText(strProductDes + Environment.NewLine);

                        if (isFirstRecord == true)
                        {


                            strSQLCommand = "select '" + strCrawlDate + "' CrawlDate,'" + productID + "' ProductID,'" + strProductDes + "' ProductDesc,'" + intPrice.ToString() + "' Price from dual";
                            isFirstRecord = false;

                        }
                        else
                            strSQLCommand = "union select '" + strCrawlDate + "' CrawlDate,'" + productID + "' ProductID,'" + strProductDes + "' ProductDesc,'" + intPrice.ToString() + "' Price from dual";

                        txtSQLCommand.AppendText(strSQLCommand + Environment.NewLine);
                    }
                }

            }



        }

        private int extractNumberFromString(string strIncludeNumber)
        {
            string b = string.Empty;
            int val = 0;
            for (int i = 0; i < strIncludeNumber.Length; i++)
            {
                if (Char.IsDigit(strIncludeNumber[i]))
                    b += strIncludeNumber[i];
            }

            if (b.Length > 0)
                val = int.Parse(b);
            return val;
        }
        


        private void btnCrawl_Click(object sender, EventArgs e)
        {
            string path = Path.Combine(Environment.CurrentDirectory, txtWebsitesFilePath.Text);
            if (!File.Exists(path))
            {
                MessageBox.Show("File " + txtWebsitesFilePath.Text + " không tồn tại");
                return;
            }

            try
            {
                
                txtProductID.Text = "";
                txtProductDesc.Text = "";
                txtProductPrice.Text = "";
                string strWebsite = "";
                
                

                    string[] websites = File.ReadAllLines(path);

                strCrawlDate = DateTime.Now.ToString("dd-MMM-yyyy");
                isFirstRecord = true;
                txtSQLCommand.Clear();
                string strSQLCommand = "insert into tblProducts(CrawlDate,ProductID,ProductDesc,Price) ";
                txtSQLCommand.AppendText(strSQLCommand + Environment.NewLine);
                for (int i = 0; i < websites.Length; i++)
                {
                    strWebsite = websites[i];
                    if (strWebsite.Contains("http"))
                    {
                        List<string> pages = getWebsiteLinks(strWebsite);
                        for (int k = 0; k < pages.Count; k++)
                            Crawl(pages[k]);
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            finally
            {
                txtSQLCommand.AppendText(";" + Environment.NewLine);

                File.WriteAllLines(txtSQLFilePath.Text, txtSQLCommand.Lines);

                //Write to the csv file
                var tsv = new StringBuilder();
                int numProducts = Math.Min(txtProductID.Lines.Length, txtProductDesc.Lines.Length);
                numProducts = Math.Min(numProducts, txtProductPrice.Lines.Length);
                for (int i = 0; i < numProducts; i++)
                {
                    var first = txtProductDesc.Lines[i].ToString();
                    var second = txtProductID.Lines[i].ToString();
                    var third = txtProductPrice.Lines[i].ToString();
                    var forth = txtProductLink.Lines[i].ToString();
                    //Create a tab-separated value (.tsv) file
                    var newLine = first + "\t" + second + "\t" + third + "\t" + forth;
                    tsv.AppendLine(newLine);
                }
                File.WriteAllText("Data/AllProducts.tsv", tsv.ToString());
                MessageBox.Show("Finished crawling! " + txtProductID.Lines.Length + " products saved!");
            }
        }
    }
}
