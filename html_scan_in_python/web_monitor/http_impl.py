'''
Created on Apr 11, 2013

@author: kovtdm
'''

import requests
import httplib
import sys
import time
import simple_http_server
from datetime import datetime
from logger import Logger

class Http():
    """Class which to contains main logic to fetch http content and
    perform tokens count accurance
     """
    
    def __init__(self, conf):
        self.conf = conf
        self.log = Logger(self.conf)            
    
    def time_spent_in(self, f, *args):
        """
        generic function to count time spent in another function
        """
        start = datetime.now()
        result = f(*args)
        time_spent = datetime.now() - start
        return time_spent, result
        
    def get_from_url(self, url):
        """
        fetches http content from the given URL
        """
        resp = None
        try:
            resp = requests.get(url)
        except Exception as e:
            print e
        
        if resp.status_code == httplib.OK:
            return resp.status_code, resp.text
        else: 
            return resp.status_code, None
        
    def count_occurance(self, content, tokens):
        """
        counts amount of given tokens in the given text
        """
        result = {}
        for s in tokens:
            occurance = content.count(s)
            result[s] = occurance
        return result
    
    def iterate_links(self, links):
        """
        iterates over list of url links, perfoms occurance count and logs results 
        """
        for url in links:
            time_spent, result = self.time_spent_in(self.get_from_url, url)            
            if result[1]:
                occurance = self.count_occurance(result[1], links[url])
                self.log.log_as_json({"time_spent":str(time_spent), "HTTP_Status": result[0], url: occurance})
            else:
                self.log.log_as_json({"time_spent":str(time_spent), "HTTP Status: ": result[0], url: None})
                
                
    def main_loop(self):
        simple_http_server.startServer()
        while 1:
            print "Scheduled task started at: " , datetime.now(), " press Ctr+C to interrupt"
            self.iterate_links(self.conf["urls_to_scan"])
            time.sleep(self.conf['scan_interval_sec'])            
        
                
    def execute(self, command, arguments):        
        if command == 'scan':
            try:
                self.main_loop()
            except KeyboardInterrupt:
                print >> sys.stderr, "Exiting ..."
                print >> sys.stderr, "Stoping server ..."
                simple_http_server.stopServer()
                print >> sys.stderr, "Server stoped..."
                sys.exit(0)
        else:
            # reservation for some other commands
            pass
             




