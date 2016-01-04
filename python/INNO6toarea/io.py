import sys 
for line in sys.stdin:
	print 'INSERT INTO `idno6toarea` VALUES ({0}, {0}, {1});'.format("'"+line[11:17]+"'","'"+line[21:-3]+"'")