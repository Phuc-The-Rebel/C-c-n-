using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace UnitTestBankAccount
{
    [TestClass]
    public class UnitTestBankAccount
    {
        private TestContext testContextInstance;
        public TestContext TestContext
        {
            get { return testContextInstance; }
            set { testContextInstance = value; }
        }
        
        [TestMethod]
        public void TestLogin2()
        {
            BankAccountApp.BankAccount banklog = new BankAccountApp.BankAccount(123, "123");
            banklog.Login2(123, "1235");
            banklog.Login2(123, "1234");
            banklog.Login2(123, "2445");
            banklog.Login2(123, "12498");
            try
            {
                Assert.AreEqual(BankAccountApp.Status.FROZEN, banklog.StatusMethod());
                TestContext.WriteLine("Result is correct-account is fozent");

            }
            catch
            {
                TestContext.WriteLine("The expected result is {0} but the actual result is {1}", BankAccountApp.Status.FROZEN, banklog.StatusMethod());
            }
        }
        public void TestHieuLuc()
        {
            BankAccountApp.BankAccount bankacc = new BankAccountApp.BankAccount(123, "123");
            bankacc.Login2(123, "123");
            bankacc.created_year = 2000;
            if (DateTime.Now.Year - bankacc.created_year > 5)
            {
                bankacc.Login(123, "123");
                TestContext.WriteLine("Het hieu luc 5 nam");
            }
            else
            {
                TestContext.WriteLine("van con hieu luc 5 nam");
            }
        }
        public void TestLogintruoc()
        {
            BankAccountApp.BankAccount bankacc = new BankAccountApp.BankAccount(123, "123");
            if(bankacc.Login(123,"123"))
            {
                Assert.AreEqual(BankAccountApp.Status.ACTIVE, bankacc.StatusMethod());
                bankacc.Deposit(1000);
                bankacc.Debit(100);
            }

        }
        static void Main()
        {
            UnitTestBankAccount UnitTest = new UnitTestBankAccount();
            UnitTest.TestLogin2(); // Dau cong thu 3
            UnitTest.TestHieuLuc(); // dau cong thu 2

        }
    }

}
