var request = require('request');
var cheerio = require('cheerio');
var crawler = require('./crawler');
function postInfo(httpRequet, parser) {

	request.post(httpRequet, function optionalCallback(err, httpResponse, body) {
		if (err) {
			return console.error('upload failed:', err);
		}
		//console.log('Upload successful!  Server responded with:', body );

		parser(body.toString())

	});

}
//数据id数组
function parseIdsThenCrawler(body) {
	var jsonD = JSON.parse(body);
	var idList = jsonD.content.result;
	for (var i = 0; i < idList.length; i++) {
		var resultIndex = idList[i];
		var id = resultIndex.positionId;
		var jobsUrl = "http://www.lagou.com/jobs/" + id + ".html?source=search&i=search-13"; //详情页
		var pa = {
			salary : resultIndex.salary,
			companyName : resultIndex.companyName,
			jobsUrl : jobsUrl
		};
		crawler.crawler(jobsUrl, parseJobRequire, pa);

	}

}
//拉钩网java工作要求
function parseJobRequire(html, parserArguments) {
	var $ = cheerio.load(html);
	var jobRequire = $('.job_bt');
	var li = "<li><div class='h'><h3><a href='" + parserArguments.jobsUrl + "'>"  + parserArguments.companyName + ":" + parserArguments.salary + "</a></h3></div>";
	console.log(li);
	console.log(jobRequire.toString() + "</li>");
}
function htmlFrame() {
	var htmlHead = '<!DOCTYPE html><html><head><meta charset="UTF-8"><title>拉钩网java工作要求20151026</title>';
	var style = '<style>.h{}.h a{background-color: #00b38a;color: #fff;} dd{padding: 6px 16px;color: #777;' +
		'font: 14px/22px "Hiragino Sans GB","微软雅黑","宋体";}</style>';
	console.log(htmlHead + style + '</head><body><ol>');
}

//启动器
function download() {
	/*
	根据浏览器xhr请求分析的数据

	url:拉钩网请求地址  城市北京
	cookie:浏览器的
	 */
	var cookie = 'user_trace_token=20151026154204-bdabc16740494db6a6699e8ca059341c; fromsite=www.google.com.hk; utm_source=""; ' + 'JSESSIONID=63EAFAACA77EF2941663BB6F9BFF2ED4; _gat=1; PRE_UTM=; PRE_HOST=; PRE_SITE=; PRE_LAND=http%3A%2F%2Fwww.lagou.com%2F;' +
		'LGUID=20151026154208-0fca14e9-7bb5-11e5-8fd0-5254005c3644; index_location_city=%E5%8C%97%E4%BA%AC;' + 'SEARCH_ID=fd70b79dba0c470e896032658e506867; _ga=GA1.2.950822083.1445845323; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1445845323;' +
		'Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1445845339; LGSID=20151026154208-0fca1208-7bb5-11e5-8fd0-5254005c3644;' +
		'LGRID=20151026154223-18645bdf-7bb5-11e5-8fd0-5254005c3644'

		var first = "true";
	var pn = 0;
	var data = {
		first : first,
		pn : pn,
		kd : "java"
	};
	var httpRequet = {
		url : 'http://www.lagou.com/jobs/positionAjax.json?city=%E5%8C%97%E4%BA%AC',
		formData : data,
		headers : {
			'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0',
			Cookie : cookie,
			Referer : 'http://www.lagou.com/zhaopin/Java/?labelWords=label',
			'Accept' : 'application/json, text/javascript, */*; q=0.01',
			'Accept-Encoding' : 'gzip, deflate',
			'Accept-Language' : 'zh-CN,zh;q=0.8',
			'Cache-Control' : 'max-age=0',
			'Connection' : 'keep-alive',
			'Content-Length' : '23',
			'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8',
			'Host' : 'www.lagou.com',
			'Origin' : 'http://www.lagou.com',
			'X-Requested-With' : 'XMLHttpRequest'

		}

	};
	htmlFrame();
	        function time() {
	            if (pn < 30) {
					postInfo(httpRequet, parseIdsThenCrawler)
					first = "false";
					pn = pn + 1;
	                setTimeout(function () {
	                    time();
	                },
	                1000*20)
	            }
	        }
	time();		
}


download();
