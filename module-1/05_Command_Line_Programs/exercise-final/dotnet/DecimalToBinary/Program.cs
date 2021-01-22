﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DecimalToBinary
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Please enter in a series of integer values (separated by spaces): ");
            string input = Console.ReadLine();
            input = input.Trim();
            string[] numbers = input.Split(' ');

            for (int i = 0; i < numbers.Length; i++)
            {
                string binary = "";

                int base10 = int.Parse(numbers[i]);
                while (base10 > 0)
                {
                    binary = (base10 % 2) + binary;
                    base10 = base10 / 2;
                }

                Console.WriteLine(numbers[i] + " in binary is " + binary);
            }

            Console.ReadLine();
        }
    }
}
