My LED and DTW spellchecker found the same spelling suggestions when the insertion, deletion, and substitution costs were all 1.  
Both were both able to give good spelling suggestions for the provided misspelled words with these costs. 
By my own estimate, almost all of these were the best possible.  
I expected both to behave the same given the cost function I used for DTW. 
The cost function would add a cost of 0 if the characters were identical and if they weren't it would add a substitution, insertion, or  deletion cost as appropriate. 
Changing one of these costs affected both algorithms. 
For example, when the substitution cost was 1, "turai" was identified as "total" in both algorithms.
When it was changed to 2, "turai" was identified as "trans". I think this second suggestion is better. 
Interestingly, with substitution set to 2, the algorithms starting behaving a little differently. 
"munntrnsatiilated" and "munuurisatuiated" were identified as "monounsaturated" by DTW but as "saturated" by LED. 
With substitution set to 1, both algorithms identified it as "monounsaturated", which is the better suggestion. 
While this testing isn't thorough, it indicates that my DTW algorithm performs better. 
Still, I prefer LED because it makes more sense in terms of spelling corrections.