<!DOCTYPE html>
<html>
<head>
    <title>React + Spring</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
      <link href="https://unpkg.com/normalize.css@^4.1.1" rel="stylesheet" />
    <link href="https://unpkg.com/@blueprintjs/core@^1.11.0/dist/blueprint.css" rel="stylesheet" />
</head>
<body>
    <div id='root'></div>
 
     <script src="https://unpkg.com/classnames@^2.2"></script> 
    <script src="https://unpkg.com/tether@^1.4"></script> 
    <script src="https://unpkg.com/react@^15.3.1/dist/react-with-addons.min.js"></script> 
    <script src="https://unpkg.com/react-dom@^15.3.1/dist/react-dom.min.js"></script> 
    <script src="https://unpkg.com/@blueprintjs/core@^1.11.0"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
 
    <script type="text/babel">
    
    const tabbar = <Blueprint.Core.Tabs2 id="Tabs2Example" >
    <Blueprint.Core.Tab2 id="rx" title="React"  />
    <Blueprint.Core.Tab2 id="ng" title="Angular" />
    <Blueprint.Core.Tab2 id="mb" title="Ember" />
    <Blueprint.Core.Tab2 id="bb" disabled title="Backbone"/>
    <Blueprint.Core.Tabs2.Expander />
    <input className="pt-input" type="text" placeholder="Search..." />
   </Blueprint.Core.Tabs2>;



   const button = React.createElement(Blueprint.Core.Spinner, {
        iconName: "predictive-analysis",
        text: "CDN Blueprint is go!",
      });
      ReactDOM.render(tabbar, document.getElementById('root'));



</script>
    
    
</body>
</html>