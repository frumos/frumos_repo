'''
Created on Apr 11, 2013

@author: kovtdm
'''

import logging
import json
import os

from datetime import datetime

class Logger():
    
    """
    Class which perfoems logging activity
    """
    
    def __init__(self, conf):
        if(conf["log_dir"]):
            self.log_dir=conf["log_dir"]
        else:
            #default location
            self.log_dir="./log_dir"
                
        self.log_file = os.sep.join([self.log_dir, "scanning_json.log"])
        self._ensure_dir(self.log_file)
        self.logger = logging.getLogger('json')
        self.logger.setLevel(logging.INFO)
        handler = logging.FileHandler(self.log_file)
        self.logger.addHandler(handler)
        
    def _ensure_dir(self, f):
        d = os.path.dirname(f)
        if not os.path.exists(d):
            os.makedirs(d)
    
    def log_as_json(self, message_map):
        """ logs given dictionary as json"""
        message_map['timestamp'] = str(datetime.now())        
        json_message = json.dumps(message_map)
        self.logger.info(json_message)