using System;
using System.Collections.Generic;

namespace TestProgramBT1
{
    public class BankAcount
    {
        private double balance;
        private int ID;
        private string password;
        private bool isFrozen;
        private Dictionary<int, int> wrongLogin;
       
        BankAcount(int ID,string password )
        {
            this.ID = ID;
            this.password = password;
            isFrozen = false;
            balance = 0;
            wrongLogin = new Dictionary<int, int>();
            wrongLogin[ID] = 0;
        }
        public void setFrozen()
        {
            isFrozen = false;
        }
        public double getBalance()
        {
            return balance;
        }
        public void setBalance(double balance)
        {
            this.balance = balance;
        }
        public bool login(int ID, string password)
        {
            if (ID != this.ID)
            {
                throw new Exception("Wrong ID.");
            }
            else (password != this.password)
            {
                throw new Exception("Wrong password.");
            }
        }
        
        public void Debit(double charge)
        {
            if(isFrozen)
            {
                throw new Exception("Account frozen.");
            }
            if(charge >= balance)
            {
                throw new ArgumentOutOfRangeException"amount");
            }
            if (charge < 0)
            {
                throw new ArgumentOutOfRangeException"amount");
            }
            balance -= charge; //  balance += charge; la sai !

        }
        public void deposit(int charge)
        {
            balance += charge;
        }

        class Program
        {
        
            static void Main(string[] args)
            {
            }
        }
    }
}
