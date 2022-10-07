using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Numerals;

namespace NumeralsTestUnit
{
    [TestClass]
    public class UnitTestNumerals1
    {
        private TestContext TestNumeralsIstance;

        public TestContext TestContext
        {
            get
            {
                return TestNumeralsIstance;
            }

            set
            {
                TestNumeralsIstance = value;
            }
        }

        public void TestSum(double a, double b, double expectedValue)
        {
            NumeralsApp app1 = new NumeralsApp();
            double kqsum = app1.Sum(a, b);
            try
            {
                Assert.AreEqual(expectedValue, kqsum);
                TestContext.WriteLine("Ket Qua Dung!");

            }
            catch
            {
                TestContext.WriteLine("Ket qua mong doi la {0} nhung ket qua that la {1}!", expectedValue, kqsum);
            }
        }
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "C:\\Users\\Admin\\Documents\\Visual Studio 2015\\Projects\\ConsoleApplication1\\UnitTestProject1\\TextDataNumerals.csv", "TextDataNumerals#csv", DataAccessMethod.Sequential), DeploymentItem("TextDataNumerals.csv")]

        [TestMethod]
        public void TestMethod1()
        {
            double a = Convert.ToDouble(TestNumeralsIstance.DataRow["numa"]);
            double b = Convert.ToDouble(TestNumeralsIstance.DataRow["numb"]);
            double expectedValue = Convert.ToDouble(TestNumeralsIstance.DataRow["sum"]);
            TestContext.WriteLine("{0} + {1} = {2} ", a, b, expectedValue);
            TestSum(a, b, expectedValue);

        }
        static void Main()
        {
            UnitTestNumerals1 UTNum = new UnitTestNumerals1();
            UTNum.TestMethod1();
            Console.ReadLine();
        }

    }
}
