=============== web monitor home task implementation =================

Author: Dmytro Kovtun
Since: 12.04.2013


Content:

- Overview
- Installation instructions
- Programm run
- Implementation description


Overview

This is a home task of "web monitor" programm


Installation instructions

Prerequsites:

- Linux-based OS
- Installed Python 2.7.x
- Installed requests python library


Intsllation
- Unpack given web_monitor.zip archive to any location

- If you don't have requests python library installed please install it with pip:
	$ pip install requests
or with easy_install:
	$ easy_install requests

- in installation directory under ./htmlScan/web_monitor configure configuration file scaner.conf according to your needs
this is a json-formated file where you can configure:

	- path to log file
	- scanning interval in seconds
	- list of URLS to scan(monitor) and list of tokens to verify their mathes (match result is how many occurance of the given token on the given html page)

example:

{
    "log_dir": "./logs",
    "scan_interval_sec":10,
    "urls_to_scan": {
    	"http://google.com":["tag", "class", "java"],
    	"http://mail.ru":["bingo", "google", "click"],
    	"http://kauppalehti.fi": ["json", "xml", "uusi"]
    }       
}

in the section urls_to_scan you can specify any URL(s) to be monitored as well list of tokens to match


Programm run

- change directory to locatin where main.py file is
- run pogramm in command line by issuing command:

	$ python main.py -c scaner.conf scan

- To stop programm type combination: 'Ctr+C'


Implemntation description

If program is running you can see the output in two places:

public one via browser on location:
http://localhost:18585/

and for administrative purposes from log file:
./logs/scanning_json

all result output is done in structured json format - taking in mind that resulting
content can be precessed by machine later on.

examnple of resulting of one json message is:

{"time_spent": "0:00:00.136918", "timestamp": "2013-04-16 14:28:18.367799", "http://kauppalehti.fi": {"xml": 2, "json": 2, "uusi": 31}, "HTTP_Status": 200}
where:
time_spent - time spend per URL request
timestamp - at which time request has beed issued
http://kauppalehti.fi - some http URL
{"xml": 2, "json": 2, "uusi": 31} - collection of tokens and their occurance on the above monitored page
HTTP_Status - HTTP status code of the response

Some architectural and design desriptions:

- As mentioned already the main content format is json which is very handy for machine processing
- module main.py is a starting point of program, provides a command line option parsing in a way of "old Unix school"
- for production quality scaner.conf properties run-time reloading should be implemented (for this task they read on programm startup)

- module simple_http_server.py - implementation of simple HTTP server which reads json log file and sends a textual http response to client (browser)
- some values are hard-coded here - production quality must be configurable
- server reasd the whole file - it is not excepted on production, some file chuck reading should be done instead

- module http_impl.py - a main logging implementation of the task. For  production quality some places where we iterate over collections might be optimized

- logger.py module provides a methods to log content in json format

- module http_impl_test.py provides basic unit test. For production quality all unit tets must be implemented

- general remark: This is not a production quality solution because:
	- no proper errors handling (must be more robust implemntation in that sence)
	- no Python egg packaging which allows Python-way installation
	- no continious integration and system tests for the application
	- no performance measurements
	- no versioning
 	- no clustering support (if any)
 	