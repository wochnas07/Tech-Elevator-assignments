﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercises
{
    public partial class StringExercises
    {
        /*
        Given two strings, a and b, return the result of putting them together in the order abba,
        e.g. "Hi" and "Bye" returns "HiByeByeHi".
        MakeAbba("Hi", "Bye") → "HiByeByeHi"
        MakeAbba("Yo", "Alice") → "YoAliceAliceYo"
        MakeAbba("What", "Up") → "WhatUpUpWhat"
        */
        public string MakeAbba(string a, string b)
        {
            return a + b + b + a;
        }
    }
}
