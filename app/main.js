const ChildProcess = require('child_process');
const fs = require('fs');
const http = require('http');

const CALCULATOR_JAR_FILE = './bin/meta-metrics-calculator-1.0-SNAPSHOT-all.jar';
const RESULTS_SAVE_FILE_PATH = './public/results.json';

let calculatorProcess = ChildProcess.spawn(
	'java', ['-jar', CALCULATOR_JAR_FILE,  RESULTS_SAVE_FILE_PATH]
);

process.stdin.pipe(calculatorProcess.stdin);
calculatorProcess.stdout.pipe(process.stdout);

calculatorProcess.on('exit', () => {
	console.log("\n\nVisit http://localhost:8080");
	console.log("Press ctrl + C to exit");
	startStaticFileServer();
});

const startStaticFileServer = () => {
	http.createServer((req, res) => {
		if (req.url === '/' || req.url === '') {
			req.url = 'index.html';
		}

		fs.readFile(__dirname + '/public/' + req.url, (err,data) => {
		  if (err) {
			res.writeHead(404);
			res.end(JSON.stringify(err));
			return;
		  }
		  res.writeHead(200);
		  res.end(data);
		});
	  }).listen(8080);
}




