# -*- coding: utf-8 -*-

'''
Created on Apr 25, 2013

@author: kovtdm

'''

"""

import requests
url = "http://das.dave.ta.gtn:8080/provisioning/services/spi/messages"
#url = "http://das.carol.ta.gtn:8080/messaging/services/spi/messages"
bad = '\x18'
auzCode = 'some' + bad + 'code'


op = '7051'
autCode = 'pzeDftAUrmxs'

getAgentId = '98651e18-5a8e-4071-9337-04078edafb79'
getAuthorizationCode = 'qQpnmJDxZRcWRhwUZPwWOXASXhFN2bXvag-j*8I' + bad + 'mVG8o5WwP3AEnuQ'

payload = {'operatorId':op, 'authorizationCode':getAuthorizationCode, 'agentId':getAgentId,  'version':'53', 'language':'en'}
resp = requests.get(url, params=payload)
print resp.text

"""

"""

import base64
print base64.b64decode(
                       
                       'eyJib2R5IjogeyJzdWJzY3JpcHRpb25fbnVtYmVyX29mX2RheXMiOiAxMDAsICJzdWJzY3JpcHRpb25fdHlwZSI6ICJwcmVkZWZpbmVkIiwgInNoYXJlZF9zZWNyZXQiOiAiYS0wZDdhNS1mZGUzZi1jYTA1MC0yYTY2YSIsICJzdWJzY3JpYmVyX2lkIjogImU0ODVlODJmLTc2NmItMGRhOC1mZGQwLTJhMzRjZWQ1YWNmMSIsICJzdWJzY3JpcHRpb25fYW1vdW50IjogMSwgInN1YnNjcmlwdGlvbl9hdHRyaWJ1dGVzIjogeyJvcmlnaW4iOiAiZnNpbyIsICJmcmVlbWl1bSI6IHRydWUsICJ0cmFuc2FjdGlvbl90YWciOiAiVFJBTlNBQ1RJT05fSURfMzBfMDEzRUFDQzA5M0M2IiwgInByb3Zpc2lvbmluZ19ncm91cCI6ICJSVE0iLCAidGllciI6ICJzb21lIHRpZXIiLCAiY2FuLnF1b3RhIjogMTAsICJpc3N1ZXIiOiAiZnNpbyJ9fSwgImhlYWRlciI6IHsicHJvZHVjdF9zZXJ2aWNlX3R5cGUiOiAiY2FuIiwgIm9yaWdpbiI6ICJmc2lvIiwgIm9wZXJhdG9yX2lkIjogIjIyMjIyMiIsICJ2ZXJzaW9uIjogIm5vbl9leGlzdGluZyIsICJtZXNzYWdlX3N1YnR5cGUiOiAibm9uZSIsICJ0aW1lc3RhbXAiOiAxMzY4Njk3OTAyMzAyLCAiZGVzdGluYXRpb24iOiAiYW55IiwgIm1lc3NhZ2VfdHlwZSI6ICJzdWJzY3JpcHRpb25fcHJvdmlzaW9uaW5nX3JlcXVlc3QiLCAidHJhbnNhY3Rpb25faWQiOiAiVFJBTlNBQ1RJT05fSURfMzBfMDEzRUFDQzA5M0M2IiwgInByaW9yaXR5IjogMH19')

"""


sttt = """соцработники
 
подходят
 
к
 
 расследованию
 
подозрительных
 
на
 
их
 
взгляд
 
дел
,
всегда
 
предполагая
 
худшее
63
,
и
 
что
 
они
 
игнорируют
,
не
 
пытаются
 
получить
 
или
 
крайне
 
выборочно
 
записывают
 
свидетельства
 
самих
 
детей
."""

print type(sttt)
s =  sttt.split()
print s


    
     
print ' '.join(s)


