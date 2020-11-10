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


const express = require('express');
const path = require('path');
const app = express();

app.use(express.static(path.join(__dirname, 'public')));

app.get('/*', function (req, res) {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

const startStaticFileServer = () => {
	app.listen(8080);
}

