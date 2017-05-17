var React = require('react');

var Default = React.createClass(
{
render: function()
{
return(
<html>
<head>

<title>Default Page by {this.props.name}</title>
</head>
<body>

{this.props.children}
</body>
</html>

)
}

});
module.exports = Default;