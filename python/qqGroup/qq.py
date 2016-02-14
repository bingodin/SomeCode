import sys 
for line in sys.stdin:
	list=line.split("\t")
	print '''BEGIN:VCARD
VERSION:3.0
N:{0};{0};;;
FN:{0}
TEL;TYPE=CELL:{1}
END:VCARD'''.format(list[0],list[1][:-1])