'''
Created on Apr 16, 2013

@author: kovtdm
'''
import unittest
import json
import random
from web_monitor.http_impl import Http

class Test(unittest.TestCase):

    def setUp(self):
        self.conf_file = conf_file = "../scaner.conf"
        self.conf = None
        with open(conf_file, 'r') as f:
            self.conf = json.load(f) 
        self.http = Http(self.conf)

    def test_count_occurance_positive(self):
        text_seed = ["some",  "dummy",  "static",  "text",  "here", "as", "a", "token_seed"]
        token_seed = ["xml", "class", "click"]
        expected = {}
        for token in token_seed:
            amount = random.randint(1, 5) 
            expected[token] = amount
            for _ in range(amount):
                text_seed.append(token)
            
        random.shuffle(text_seed)
        print ' '.join(text_seed)
        actual = self.http.count_occurance(' '.join(text_seed), token_seed)
        self.assertEquals(actual, expected, "Number of tokens should be equal in original text and count of occurances")        
      

if __name__ == "__main__":   
    unittest.main()