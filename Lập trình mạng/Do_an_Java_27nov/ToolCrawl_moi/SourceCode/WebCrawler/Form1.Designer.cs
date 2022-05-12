namespace WebCrawler
{
    partial class frmMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnCrawl = new System.Windows.Forms.Button();
            this.txtSQLFilePath = new System.Windows.Forms.TextBox();
            this.lblSQLFilePath = new System.Windows.Forms.Label();
            this.txtWebsitesFilePath = new System.Windows.Forms.TextBox();
            this.lblWebsitesFilePath = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtProductLink = new System.Windows.Forms.TextBox();
            this.txtSQLCommand = new System.Windows.Forms.TextBox();
            this.lbImgSource = new System.Windows.Forms.Label();
            this.lblProductDesc = new System.Windows.Forms.Label();
            this.lblProductLink = new System.Windows.Forms.Label();
            this.txtProductPrice = new System.Windows.Forms.TextBox();
            this.txtProductDesc = new System.Windows.Forms.TextBox();
            this.txtProductID = new System.Windows.Forms.TextBox();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.panel1.Controls.Add(this.btnCrawl);
            this.panel1.Controls.Add(this.txtSQLFilePath);
            this.panel1.Controls.Add(this.lblSQLFilePath);
            this.panel1.Controls.Add(this.txtWebsitesFilePath);
            this.panel1.Controls.Add(this.lblWebsitesFilePath);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.txtProductLink);
            this.panel1.Controls.Add(this.txtSQLCommand);
            this.panel1.Controls.Add(this.lbImgSource);
            this.panel1.Controls.Add(this.lblProductDesc);
            this.panel1.Controls.Add(this.lblProductLink);
            this.panel1.Controls.Add(this.txtProductPrice);
            this.panel1.Controls.Add(this.txtProductDesc);
            this.panel1.Controls.Add(this.txtProductID);
            this.panel1.Location = new System.Drawing.Point(34, 26);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(962, 460);
            this.panel1.TabIndex = 8;
            // 
            // btnCrawl
            // 
            this.btnCrawl.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnCrawl.Location = new System.Drawing.Point(18, 16);
            this.btnCrawl.Name = "btnCrawl";
            this.btnCrawl.Size = new System.Drawing.Size(100, 30);
            this.btnCrawl.TabIndex = 26;
            this.btnCrawl.Text = "Crawl";
            this.btnCrawl.UseVisualStyleBackColor = true;
            this.btnCrawl.Click += new System.EventHandler(this.btnCrawl_Click);
            // 
            // txtSQLFilePath
            // 
            this.txtSQLFilePath.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtSQLFilePath.Location = new System.Drawing.Point(472, 393);
            this.txtSQLFilePath.Name = "txtSQLFilePath";
            this.txtSQLFilePath.Size = new System.Drawing.Size(254, 29);
            this.txtSQLFilePath.TabIndex = 25;
            this.txtSQLFilePath.Text = "Data/SQLCommands.sql";
            // 
            // lblSQLFilePath
            // 
            this.lblSQLFilePath.AutoSize = true;
            this.lblSQLFilePath.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSQLFilePath.Location = new System.Drawing.Point(378, 396);
            this.lblSQLFilePath.Name = "lblSQLFilePath";
            this.lblSQLFilePath.Size = new System.Drawing.Size(88, 24);
            this.lblSQLFilePath.TabIndex = 24;
            this.lblSQLFilePath.Text = "File SQL:";
            // 
            // txtWebsitesFilePath
            // 
            this.txtWebsitesFilePath.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtWebsitesFilePath.Location = new System.Drawing.Point(192, 393);
            this.txtWebsitesFilePath.Name = "txtWebsitesFilePath";
            this.txtWebsitesFilePath.Size = new System.Drawing.Size(180, 29);
            this.txtWebsitesFilePath.TabIndex = 23;
            this.txtWebsitesFilePath.Text = "Config/Websites.txt";

            // 
            // lblWebsitesFilePath
            // 
            this.lblWebsitesFilePath.AutoSize = true;
            this.lblWebsitesFilePath.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblWebsitesFilePath.Location = new System.Drawing.Point(12, 391);
            this.lblWebsitesFilePath.Name = "lblWebsitesFilePath";
            this.lblWebsitesFilePath.Size = new System.Drawing.Size(174, 24);
            this.lblWebsitesFilePath.TabIndex = 22;
            this.lblWebsitesFilePath.Text = "Danh sách website:";
            
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(450, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(291, 31);
            this.label1.TabIndex = 21;
            this.label1.Text = "Tool crawl bài tập Java";
            // 
            // txtProductLink
            // 
            this.txtProductLink.Location = new System.Drawing.Point(723, -3);
            this.txtProductLink.Multiline = true;
            this.txtProductLink.Name = "txtProductLink";
            this.txtProductLink.Size = new System.Drawing.Size(176, 81);
            this.txtProductLink.TabIndex = 20;
            this.txtProductLink.Visible = false;
            // 
            // txtSQLCommand
            // 
            this.txtSQLCommand.Location = new System.Drawing.Point(500, 4);
            this.txtSQLCommand.Multiline = true;
            this.txtSQLCommand.Name = "txtSQLCommand";
            this.txtSQLCommand.Size = new System.Drawing.Size(176, 66);
            this.txtSQLCommand.TabIndex = 19;
            this.txtSQLCommand.Visible = false;
            // 
            // lbImgSource
            // 
            this.lbImgSource.AutoSize = true;
            this.lbImgSource.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbImgSource.Location = new System.Drawing.Point(746, 81);
            this.lbImgSource.Name = "lbImgSource";
            this.lbImgSource.Size = new System.Drawing.Size(181, 31);
            this.lbImgSource.TabIndex = 12;
            this.lbImgSource.Text = "Giá sản phẩm";
            // 
            // lblProductDesc
            // 
            this.lblProductDesc.AutoSize = true;
            this.lblProductDesc.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblProductDesc.Location = new System.Drawing.Point(281, 81);
            this.lblProductDesc.Name = "lblProductDesc";
            this.lblProductDesc.Size = new System.Drawing.Size(206, 31);
            this.lblProductDesc.TabIndex = 11;
            this.lblProductDesc.Text = "Mô tả sản phẩm";
            
            // 
            // lblProductLink
            // 
            this.lblProductLink.AutoSize = true;
            this.lblProductLink.Font = new System.Drawing.Font("Microsoft Sans Serif", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblProductLink.Location = new System.Drawing.Point(12, 81);
            this.lblProductLink.Name = "lblProductLink";
            this.lblProductLink.Size = new System.Drawing.Size(176, 31);
            this.lblProductLink.TabIndex = 10;
            this.lblProductLink.Text = "Mã sản phẩm";
           
            // 
            // txtProductPrice
            // 
            this.txtProductPrice.Location = new System.Drawing.Point(752, 124);
            this.txtProductPrice.Multiline = true;
            this.txtProductPrice.Name = "txtProductPrice";
            this.txtProductPrice.Size = new System.Drawing.Size(189, 248);
            this.txtProductPrice.TabIndex = 9;
           
            // 
            // txtProductDesc
            // 
            this.txtProductDesc.Font = new System.Drawing.Font("Times New Roman", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtProductDesc.Location = new System.Drawing.Point(287, 125);
            this.txtProductDesc.Multiline = true;
            this.txtProductDesc.Name = "txtProductDesc";
            this.txtProductDesc.Size = new System.Drawing.Size(439, 247);
            this.txtProductDesc.TabIndex = 8;
            
            // 
            // txtProductID
            // 
            this.txtProductID.Location = new System.Drawing.Point(16, 126);
            this.txtProductID.Multiline = true;
            this.txtProductID.Name = "txtProductID";
            this.txtProductID.Size = new System.Drawing.Size(250, 246);
            this.txtProductID.TabIndex = 7;
          
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(994, 498);
            this.Controls.Add(this.panel1);
            this.MaximizeBox = false;
            this.Name = "frmMain";
            this.Text = "Website Crawler";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.TextBox txtProductPrice;
        private System.Windows.Forms.TextBox txtProductDesc;
        private System.Windows.Forms.TextBox txtProductID;
        private System.Windows.Forms.Label lblProductLink;
        private System.Windows.Forms.Label lbImgSource;
        private System.Windows.Forms.Label lblProductDesc;
        private System.Windows.Forms.TextBox txtSQLCommand;
        private System.Windows.Forms.TextBox txtProductLink;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtSQLFilePath;
        private System.Windows.Forms.Label lblSQLFilePath;
        private System.Windows.Forms.TextBox txtWebsitesFilePath;
        private System.Windows.Forms.Label lblWebsitesFilePath;
        private System.Windows.Forms.Button btnCrawl;
    }
}

