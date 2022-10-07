using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BankAccountApp
{
    public enum Status
    {
        FROZEN,
        ACTIVE,
        LOGGED_IN,
        LOGGED_OUT
    };
    public class BankAccount
    {
        private int id;
        private string password;
        private double balance;
        private Status m_status;
        private int wrong_login;
        public int created_year;
        public BankAccount(int id, string password)
        {
            this.id = id;
            this.password = password;
            this.balance = 0;
            this.m_status = Status.ACTIVE;
            this.wrong_login = 0;
            this.created_year = DateTime.Now.Year;
        }
        public double GetBalance()
        {
            return balance;
        }
        public void Debit(double charge)
        {
            if (balance < charge)
                throw new ArgumentOutOfRangeException("Debit amout exceeds balance.");
            else
                if (charge < 0)
                throw new ArgumentOutOfRangeException("Charge less than zero");
            else
                if (m_status == Status.FROZEN)
                throw new Exception("Account is frozen");
            balance -= charge;
        }
        public bool Login(int id, string pass)
        {
            if (id != this.id)
            {
                throw new Exception("Wrong ID.");
            }
            else if (pass != this.password)
            {
                ++wrong_login;
                if (wrong_login > 5)
                {
                    m_status = Status.FROZEN;
                }
                else if (m_status == Status.ACTIVE || m_status == Status.LOGGED_OUT)
                {
                    wrong_login = 0;
                    m_status = Status.LOGGED_IN;
                    System.Console.WriteLine("Succesfully login.");
                    return true;
                }
            }
            System.Console.WriteLine("Failed login");
            return false;
        }
        public void Logout()
        {
            m_status = Status.LOGGED_OUT;
        }
        public void Deposit(double amout)
        {
            if (m_status == Status.FROZEN)
                throw new Exception("Account is frozen");
            balance += amout;
        }
        public void Frozen()
        {
            m_status = Status.FROZEN;
        }
        public void Active()
        {
            m_status = Status.ACTIVE;
        }
        public Status StatusMethod()
        {
            return m_status;
        }
        public Status Login2(int id, string pass)
        {
            if (id != this.id)
            {
                throw new Exception("Wrong ID.");
            }
            else if (pass != this.password)
            {
                ++wrong_login;
                if (wrong_login > 5)
                {
                    m_status = Status.FROZEN;
                }
                else
                {
                    wrong_login = 0;
                    m_status = Status.ACTIVE;
                    System.Console.WriteLine("Succesfully login.");
                }
               
            }
            System.Console.WriteLine("Failed login");
            return m_status = Status.ACTIVE;
        }
        static void Main(string[] args)
        {

        }
    }

}
