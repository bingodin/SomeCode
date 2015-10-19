var request = require('request');
var cheerio = require('cheerio');
var crawler = require('./crawler');
//拉钩网请求地址
var url='http://www.lagou.com/jobs/positionAjax.json?city=%E5%8C%97%E4%BA%AC';
function getInfo(url, data){
	
request.post({url:url, formData: data}, function optionalCallback(err, httpResponse, body) {
  if (err) {
    return console.error('upload failed:', err);
  }
  //console.log('Upload successful!  Server responded with:', body);
   
         parseIds(body.toString())

 
});	
	
}
//数据id数组  
function parseIds (body){
var jsonD=JSON.parse(body);
var idList	=jsonD.content.result;
for(var i=0;i<idList.length;i++){
	id =idList[i].positionId;
	var jobsUrl ="http://www.lagou.com/jobs/"+id+".html?source=search&i=search-13";//详情页
	crawler.crawler(jobsUrl,parseJobRequire)
}
}
var counts=1;
//拉钩网java工作要求
function parseJobRequire (html){
  var  $ = cheerio.load(html);
  var jobRequire = $('.job_bt');
  	 console.log("<h3>"+counts+"<h3/>");
	 counts++;
	 console.log(jobRequire.toString());
}

var pn=0;
first="true"
var data = {first:first,pn:pn,kd:"java"};


do
{
getInfo(url,data)
pn=pn+1
first="false"
}
while (pn<50)