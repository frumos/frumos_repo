'''
Created on Apr 11, 2013

@author: kovtdm
'''

import sys
import getopt
import json
from http_impl import Http


def main(argv=None):
    # default configuration file
    conf_file = "./scaner.conf"
    conf = {}     

    if argv is None:
        argv = sys.argv
    try:
        opts, args = getopt.getopt(argv[1:], "c:h:")        
        for o, a in opts:
            if o in ("-c"):
                conf_file = a.strip()
                with open(conf_file, 'r') as f:
                    conf = json.load(f)                
            elif o in ("-h"):
                usage()
                
    except getopt.GetoptError, err:
        print str(err)
        usage()
        sys.exit(2)

    command = None
    arguments = None

    if len(args) >= 1:
            command = args[0].strip().lower()
            arguments = args[1:]
    else:
        print __doc__
        return 1

    http = Http(conf)
    http.execute(command, arguments)


def usage():
    print "usage: %prog [-h|--help] | -c|--conf conf_file] scan"

if __name__ == '__main__':
    sys.exit(main())
    
    
    
