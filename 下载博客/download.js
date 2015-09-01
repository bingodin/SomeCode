cli = require('./crawler'),
parser = require('./parsehtmljs');
var url='http://www.yinwang.org/';
cli.crawler(url,parser.parseArticleTopic);
//node download.js >wangyin-blogs.html