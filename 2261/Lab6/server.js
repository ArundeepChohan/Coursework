

var express = require('express');

var app = express();

app.disable('x-powered-by');

var handlebars = require('express-handlebars').create({defaultLayout:'main'});

app.engine('handlebars', handlebars.engine);

app.set('view engine', 'handlebars');

app.set('port', process.env.PORT || 3000);

// Create a directory called public and then a directory
// named img inside of it and put your logo in there
app.use(express.static(__dirname + '/public'));



// Define some routes. app.get receives a path and a
// function and it defines our routes. The path isn't
// case sensitive and doesn't care about trailing path
// information.
// The req object represents the HTTP request and
// contains the query string, parameters, body, header
// The res object is the response Express sends
// when it receives a request
app.get('/', function(req, res){
  // Point at the home.handlebars view
  res.render('home',{title : "web page", name:"Arundeep Chohan"});
});
app.get('/realtime/show', function(req, res){
  res.render('data');
});
//URL parameters
app.get('/name/:username', function(req, res){
  res.json({name:req.params.username, test1:req.query.test1, test2:req.query.test2});
});

app.get('/name/:firstname/:lastname', function(req, res){
  res.json({firstname:req.params.firstname, lastname:req.params.lastname});
});

//URL querys
app.get('/query', function(req, res){
  res.json({test1:req.query.test1, test2:req.query.test2});
});

app.get('/queryjson', function(req, res){  
        res.json(req.query);
});


// require bodyParser
var bodyParser = require('body-parser');
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: true }));
// parse application/json
app.use(bodyParser.json());
app.put('/resource', function(req, res){
  var body = req.body;
  console.log(body);
  res.json(body);
});



// This is an example of middleware It receives a request
// object, response object and the next function
// As we look for the correct information to serve it executes
// and then next() says to continue down the pipeline
app.use(function(req, res, next){
  console.log('Looking for URL : ' + req.url);
  next();
});

// You can also report and throw errors
app.get('/junk', function(req, res, next){
  console.log('Tried to access /junk');
  throw new Error('/junk does\'t exist');
});

// Catches the error and logs it and then continues
// down the pipeline
app.use(function(err, req, res, next){
  console.log('Error : ' + err.message);
  next();
});

// If we want /about/contact we'd have to define it
// before this route
app.get('/about', function(req, res){
  // Point at the about.handlebars view
  // Allow for the test specified in tests-about.js
  res.render('about');
});
 


// Link to contact view
app.get('/contact', function(req, res){

  // CSRF tokens are generated in cookie and form data and
  // then they are verified when the user posts
  res.render('contact', { csrf: 'CSRF token here' });
});



// Defines a custom 404 Page and we use app.use because
// the request didn't match a route (Must follow the routes)
app.use(function(req, res) {
  // Define the content type
  res.type('text/html');

  // The default status is 200
  res.status(404);

  // Point at the 404.handlebars view
  res.render('404');
});

// Custom 500 Page
app.use(function(err, req, res, next) {
  console.error(err.stack);
  res.status(500);

  // Point at the 500.handlebars view
  res.render('500');
});

app.listen(app.get('port'), function(){
  console.log('Express started on http://localhost:' +
    app.get('port') + '; press Ctrl-C to terminate');
});
//RESTful JSON
app.post('/post', function(req, res){
  // return a JSON for post
  res.json({type : "json", value:"post"});
});


app.put('/put', function(req, res){
  // return a JSON for post
  res.json({type : "json", value:"put"});
});
//-----

var fs = require('fs');
//----------------- 
//reads all of file
var path= './users.json';

 
app.get('/users', function (req, res) {  
var content = fs.readFileSync(path,'utf8');
console.log(JSON.parse(content));
 var jsonContent = JSON.parse(content);
  res.json({jsonContent});
});

app.post('/users', function (req, res) {  

    var user={"'user':{'id':'002','firstname':'arundeep', 'lastname':'chohan'}"};
	fs.appendFile(path, user, function (err) {
console.log("The file was saved!");
});
    //res.send('POST /users insert a user with a user JSON object');
});

app.delete('users/:id', function (req, res) {
var indexOfCouseInJson = json.map(function(item) { return item.id; }).indexOf(req.params.id); //find the index of :id
  if(indexOfCouseInJson === -1) {
    res.statusCode = 404;
    return res.send('Error 404: No quote found');
  }

  var result = json.splice(indexOfCouseInJson,1);
  fs.writeFile(path, JSON.stringify(result), function(err){
   if(err) throw err;
   res.json(true);
 });
});
app.put('users/:id ', function (req, res) {
fs.readFile(path, function(err, data) {
  var obj = JSON.parse(data);
  obj.id('id':req.params.id);
  var newJSON = JSON.stringify(obj);
  fs.writeFile(path, newJSON, function(err) {
    console.log('done');
  });
});
  //res.send('PUT /users/:id update the user information with a user JSON object');
});

/*Provide RESTful API "GET /realtime/data" to respone a JSON {"data":" xxx "}, where the xxx should be a random number.
*/
app.get('/realtime/data', function (req, res) { 
var x =Math.floor((Math.random() * 10) + 1);
  res.json({"data": x });
});
app.get('/users/control', function (req, res) { 
 res.render('control');

});
//-----------------

//------