using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Numerals
{
    public class NumeralsApp
    {
        public NumeralsApp()
        {

        }
        public double Sum(double a,double b)
        {
            return a + b;
        }

        public double Substract(double a, double b)
        {
            return a - b;
        }

        public double Divide(double a,double b)
        {
            return a / b;
        }
        public int factorize(int n)
        {
            int FGT = 1;
            int PreGT = 1;
            for(int i = 2; i <= n; i ++)
            {
                PreGT = PreGT * i;
                FGT = PreGT;
            }
            return FGT;
        }
        
        public bool IsPrime(int n)
        {
            if (n < 2)
            {
                return false;
            }
            for (int i = 2; i <= Math.Sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    return false;
                }
            }
            return true;

        
        static void Main(string[] args)
        {

        }
    }
}
