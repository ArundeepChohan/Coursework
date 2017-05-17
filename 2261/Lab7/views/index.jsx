var React = require('react');
var DefaultLayout = require('./layout/Default');
var IndexComponent = React.createClass(
{
render:function()
{
return(
<DefaultLayout name={this.props.name}>

<div>
<h1> welcome </h1>
</div>

</DefaultLayout>
)}
});
module.exports = IndexComponent;


