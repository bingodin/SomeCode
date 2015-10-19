var request = require('request');
var cheerio = require('cheerio');
var crawler = require('./crawler');
//post请求数据
function getInfo(url, data,p){
	
request.post({url:url, formData: data}, function optionalCallback(err, httpResponse, body) {
  if (err) {
    return console.error('upload failed:', err);
  }
  //console.log('Upload successful!  Server responded with:', body);
   
         p(body.toString())

 
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
  var jobRequire = $('.job_bt');//工作要求所在div
  	 console.log("<h3>"+counts+"</h3>");
	 counts++;
	 console.log(jobRequire.toString());
}
//拉钩网请求地址 city=北京
var url='http://www.lagou.com/jobs/positionAjax.json?city=%E5%8C%97%E4%BA%AC';
//  从浏览器分析的xhr数据所得
//请求数据构成  分页形式的数据
var pn=0;
first="true"
var data = {first:first,pn:pn,kd:"java"};


do
{
getInfo(url,data,parseIds )
pn=pn+1
first="false"
}
while (pn<50)