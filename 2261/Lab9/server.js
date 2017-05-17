var express = require('express');
var app = express();

var mongojs = require('mongojs');
var db = mongojs('test', ['users']);
// require bodyParser
var bodyParser = require('body-parser');

// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }));

// parse application/json
app.use(bodyParser.json());


app.get('/profile', function (req, res) {

	db.users.find();

});
app.put('/profile/:profile_id', function (req, res) {

	console.log(req.body);
	db.users.update(
	{"_id": req.params.profile_id},
${"firstName":"match" }
	);

});
app.post('/profile', function (req, res) {

	console.log(req.body);
	db.users.insert(req.body, function(err, records) {
    	if (err) {
        		console.log(err);
    	} else {
        	res.end("Inserted! "+err+" "+records);
        	console.dir(records);
    	}
	});

});
app.delete('/profile/:profile_id', function (req, res) {

	var profile_id = req.params.profile_id;
	console.log("Deleting "+profile_id);
	db.users.remove({"id_":profile_id}, function(err, records) {
    	if (err) {
        		console.log(err);
    	} else {
        	res.end("Deleted! "+err+" "+records);
        	console.dir(records);
    	}
	});

});

	
	
	
	
	