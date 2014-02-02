'''
Created on Apr 12, 2013

@author: kovtdm
'''

import BaseHTTPServer
import threading
import httplib
import json

from time import sleep

host = "localhost"
port = 18585
log_file = "./logs/scanning_json.log"

class SimpleHttpHandler(BaseHTTPServer.BaseHTTPRequestHandler):
    
    def do_GET(self):        
        self.send_response(200)
        self.send_header("Content-type", "text/html")
        self.end_headers()
        self.generate_event_type_percentage = 0.5
        response = self._generate_response()
        response = response.encode('utf-8')
        self.wfile.write(response)
        return
        
    def do_QUIT(self):
        self.send_response(200)
        self.end_headers()
        self.server.stop = True
        return
    
    def _generate_response(self):
        with open(log_file, 'r') as f:
            content = f.read()                
        return content
    

class SimpleHttpServer(BaseHTTPServer.HTTPServer):
        
    def serve_forever (self):        
        self.stop = False
        while not self.stop:
            print "Handling request"
            self.handle_request()
        return
    
def startServer():
    
    print "Starting simple server on host %s and port %s" %(host, port)
    httpd = SimpleHttpServer((host, port), SimpleHttpHandler)
    t = threading.Thread(target = httpd.serve_forever)
    t.start()
    print "simple HTTP server started"

def stopServer():
    conn = httplib.HTTPConnection(host + ":%d" % port)
    conn.request("QUIT", "/")
    response = conn.getresponse()
    print "1st run", response.status, response.reason

    # We do it second time to make OS aware, that the socket no longer has service attached to it.
    sleep(3) # wait that service had time to shutdown.
    try:
        conn = httplib.HTTPConnection(host + ":%d" % port)
        conn.request("QUIT", "/")
        response = conn.getresponse()
        print "2st run", response.status, response.reason
    except Exception,msg:
        print "2nd call error : ",msg

    print "simple server stopped"
    return