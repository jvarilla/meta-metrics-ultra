(this.webpackJsonpdashboard=this.webpackJsonpdashboard||[]).push([[0],{188:function(e,t,s){},189:function(e,t,s){},369:function(e,t,s){},370:function(e,t,s){},371:function(e,t,s){},377:function(e,t,s){},378:function(e,t,s){},379:function(e,t,s){},380:function(e,t,s){},381:function(e,t,s){},382:function(e,t,s){},383:function(e,t,s){},384:function(e,t,s){},385:function(e,t,s){},386:function(e,t,s){},391:function(e,t,s){"use strict";s.r(t);var c=s(2),a=s(1),r=s.n(a),n=s(63),i=s.n(n),l=(s(188),s(8)),o=s(9),d=s(11),j=s(10),m=(s(189),s(26)),b=s(14),h=s(12),u=s(13),O=(s(369),["#1717BF","#000062","#707070","#FF8042"]),x=(Math.PI,function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){var e=this.props.dataForChart;return Object(c.jsxs)("div",{className:"pieChartContainer",children:[Object(c.jsx)("h2",{children:this.props.title}),Object(c.jsx)(u.h,{children:Object(c.jsxs)(u.g,{children:[Object(c.jsx)(u.f,{data:e,labelLine:!0,label:function(e){return e.value},outerRadius:95,fill:"#8884d8",dataKey:"value",children:e.map((function(e,t){return Object(c.jsx)(u.d,{fill:O[t%O.length]},"cell-".concat(t))}))}),Object(c.jsx)(u.i,{}),Object(c.jsx)(u.e,{})]})})]})}}]),s}(a.PureComponent));x.jsfiddleUrl="https://jsfiddle.net/alidingling/c9pL8k61/";s(370);var p=function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){var e=this.props.metricsData;return Object(c.jsxs)("div",{className:"barChartsContainer",children:[Object(c.jsx)("h2",{children:this.props.title}),Object(c.jsxs)(u.b,{data:e,margin:{top:20,right:30,left:20,bottom:5},children:[Object(c.jsx)(u.c,{strokeDasharray:"3 3"}),Object(c.jsx)(u.j,{dataKey:"name"}),Object(c.jsx)(u.k,{}),Object(c.jsx)(u.i,{}),Object(c.jsx)(u.e,{}),Object(c.jsx)(u.a,{dataKey:"pv",stackId:"a",fill:"#0005D4"}),Object(c.jsx)(u.a,{dataKey:"uv",stackId:"a",fill:"#000493"})]})]})}}]),s}(a.Component);p.jsfiddleUrl="https://jsfiddle.net/alidingling/90v76x08/";s(371);var f=function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){return Object(c.jsx)("div",{children:Object(c.jsxs)("nav",{className:"navbar navbar-expand-lg navbar-light navbar-meta",children:[Object(c.jsxs)("div",{className:"d-flex flex-grow-1 nav-bar-inner",children:[Object(c.jsx)("a",{className:"navbar-brand",href:"/",children:Object(c.jsx)("img",{src:"/images/logo-symbol.png",width:"50",height:"50",alt:"",loading:"lazy"})}),Object(c.jsx)("div",{className:"w-100 text-right",children:Object(c.jsx)("button",{className:"navbar-toggler",type:"button","data-toggle":"collapse","data-target":"#mobile-menu",children:Object(c.jsx)("span",{className:"navbar-toggler-icon",children:Object(c.jsx)(h.a,{icon:"bars"})})})})]}),Object(c.jsx)("div",{className:"collapse navbar-collapse text-center",id:"mobile-menu",children:Object(c.jsxs)("ul",{className:"navbar-nav ml-auto flex-nowrap nav-pills",children:[Object(c.jsx)("li",{className:"nav-item",children:Object(c.jsxs)(m.b,{to:"/",activeClassName:"active",className:"nav-link",children:[Object(c.jsx)(h.a,{icon:"info-circle"}),"\xa0 Information"]})}),Object(c.jsx)("li",{className:"nav-item",children:Object(c.jsxs)(m.b,{to:"/dashboard",activeClassName:"active",className:"nav-link",children:[Object(c.jsx)(h.a,{icon:"align-left"}),"\xa0 Summary"]})})]})})]})})}}]),s}(a.Component),v=(s(377),function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){return Object(c.jsx)("div",{children:Object(c.jsx)("nav",{"aria-label":"breadcrumb",children:Object(c.jsxs)("ol",{className:"breadcrumb",children:[Object(c.jsx)("li",{className:"breadcrumb-item","aria-current":"page",children:Object(c.jsx)("a",{href:"/",children:"Information"})}),Object(c.jsx)("li",{className:"breadcrumb-item active","aria-current":"page",children:Object(c.jsx)("a",{href:"/dashboard",children:"Metrics Summary"})})]})})})}}]),s}(a.Component)),N=(s(378),function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){return Object(c.jsx)("div",{children:Object(c.jsx)("h1",{className:"LargeTitle",children:this.props.name})})}}]),s}(a.Component)),y=(s(379),function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){return Object(c.jsx)("div",{children:Object(c.jsx)("p",{className:"texts-paragraph",children:this.props.text})})}}]),s}(a.Component)),g=(s(380),function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){return this.props.metricsData?Object(c.jsxs)("div",{children:[Object(c.jsx)("div",{className:"text-center pt-3",children:Object(c.jsx)(y,{text:"All Metrics"})}),Object(c.jsx)("div",{className:"list-group",children:this.props.metricsData.classes.map((function(e,t){return Object(c.jsxs)(m.b,{to:"/metrics/classes/"+t,activeClassName:"active",className:"list-group-item list-group-item-action",children:[Object(c.jsx)(h.a,{icon:"chart-bar"}),"\xa0",e.className]},"class"+t)}))})]}):Object(c.jsx)("div",{children:Object(c.jsx)("h2",{children:"Loading..."})})}}]),s}(a.Component)),D=(s(381),s(382),a.Component,s(383),function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){this.props.list;var e=this.props.r1,t=this.props.r2,s=this.props.num;if(1==this.props.oneNum)return s>=e&&s<=t?Object(c.jsx)(h.a,{icon:"thumbs-up"}):Object(c.jsx)(h.a,{icon:"thumbs-down"})}}]),s}(a.Component)),C=function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){var e=this;return Object.keys(this.props.metricsData.summary).map((function(t,s){var a=0;if(2==s?a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:5*e.props.metricsData.summary[t],oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 The number of lines in the code are counted and based on the number of lines the cost is calculated."]}):3==s?a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:2*e.props.metricsData.summary[t],oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design."]}):4==s||5==s?a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:2*e.props.metricsData.summary[t],oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design. Moderate Values are better."]}):6==s?a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:10,oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 The deeper a class is in the hierarchy, the higher the degree of methods inheritance, making it more complex to predict its behavior. Good values are between 0 and 4."]}):7==s?a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:e.props.metricsData.summary[t],oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 The number of methods and complexity of methods involved is a direct predictor of how much time and effort is required to develop and maintain the class. Smaller values are better."]}):8==s?a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:50,oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design. Moderate values are better."]}):9==s&&(a=Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:50,oneNum:!0,num:e.props.metricsData.summary[t]}),"\xa0 This measures the complexity of the class in terms of method calls. It is calculated by adding the number of methods in the class (not including inherited methods) plus the number of distinct method calls made by the methods in the class."]})),0==s)return Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsx)("h2",{children:t}),Object(c.jsx)("p",{className:"text-center",children:"This is the path to the src files"}),Object(c.jsxs)("p",{className:"text-center",children:[Object(c.jsx)(h.a,{icon:"file-alt"}),"\xa0",e.props.metricsData.summary.pathToSrc]})]})},s);if(1==s)return Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsx)("h2",{children:t}),Object(c.jsx)("p",{className:"text-center",children:"This is the path to the bin files"}),Object(c.jsxs)("p",{className:"text-center",children:[Object(c.jsx)(h.a,{icon:"file-alt"}),"\xa0",e.props.metricsData.summary.pathToBin]})]})},s);var r=0==parseFloat(e.props.metricsData.summary[t])?.001:parseFloat(e.props.metricsData.summary[t]),n=[{name:t+" - "+parseFloat(e.props.metricsData.summary[t].toFixed(2)),value:parseFloat(r.toFixed(2))},{name:"Init",value:1}];return Object(c.jsx)("div",{className:"col-lg-4 col-md-4 col-sm-12",children:Object(c.jsx)("div",{className:"card",children:Object(c.jsxs)("div",{className:"card-body",children:[Object(c.jsx)("div",{className:"myContainerPieChart",children:Object(c.jsx)(x,{title:t,dataForChart:n})}),Object(c.jsx)("div",{className:"mt-4 text-center",children:a})]})})},s)}))}}]),s}(a.Component),k=(s(384),s(385),function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){return Object(c.jsx)("div",{children:Object(c.jsx)("div",{className:"fixed-bottom",children:Object(c.jsxs)("div",{className:"btn-group dropup dropupArea",children:[Object(c.jsx)("a",{role:"button",id:"mobileButton",className:"btn btn-default btn-lg btn-block dropdown-toggle","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false",children:"View All Metrics"}),Object(c.jsxs)("div",{className:"dropdown-menu mobileDropdownMenu",children:[Object(c.jsx)("div",{className:"text-center",children:Object(c.jsx)(y,{text:"All Metrics"})}),this.props.metricsData.classes.map((function(e,t){return Object(c.jsxs)("a",{href:"/metrics/classes/"+t,className:"dropdown-item",children:[Object(c.jsx)(h.a,{icon:"chart-bar"}),"\xa0",e.className]},"class"+t)}))]})]})})})}}]),s}(a.Component)),w=(s(386),["#1717BF","#000062","#707070","#000036"]),M=(Math.PI,function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){var e=this.props.metricsData;return Object(c.jsxs)("div",{className:"simplePieChartContainer",children:[Object(c.jsx)("h2",{children:this.props.title}),Object(c.jsx)(u.h,{children:Object(c.jsxs)(u.g,{children:[Object(c.jsx)(u.f,{data:e,labelLine:!0,label:function(e){try{return e.value.toFixed(1)}catch(t){return""}},outerRadius:150,fill:"#8884d8",dataKey:"value",children:e.map((function(e,t){return Object(c.jsx)(u.d,{fill:w[t%w.length]},"cell-".concat(t))}))}),Object(c.jsx)(u.i,{}),Object(c.jsx)(u.e,{})]})})]})}}]),s}(a.PureComponent));M.jsfiddleUrl="https://jsfiddle.net/alidingling/c9pL8k61/";var F=function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){return Object(l.a)(this,s),t.apply(this,arguments)}return Object(o.a)(s,[{key:"render",value:function(){if(this.props.classMetrics){var e,t=this.props.classMetrics,s=t.dit.ancestors.map((function(e,s){return{name:e,value:t.dit.value}}));if(0==t.dit.ancestors.length){e=Object(c.jsx)(M,{title:"Ancestors",metricsData:[{name:"Ancestors not found",value:.01}]})}else e=Object(c.jsx)(M,{title:"Ancestors",metricsData:s});var a=Object.keys(t.wmc.numberOfMethods).map((function(e,s){var c=0==t.wmc.numberOfMethods[e]?.01:t.wmc.numberOfMethods[e];return{name:e+" - "+t.wmc.numberOfMethods[e],value:c}})),r=Object.keys(t.numFields).map((function(e,s){var c=0==t.numFields[e]?.01:t.numFields[e];return{name:e+" - "+t.numFields[e],value:c}})),n=Object.keys(t.rfc).map((function(e,s){var c=0==t.rfc[e]?.01:t.rfc[e];return{name:e+" - "+t.rfc[e],value:c}})),i=Object.keys(t.interfaces).map((function(e,s){var c=0==t.interfaces[e]?.01:t.interfaces[e];return{name:e+" - "+t.interfaces[e],value:c}}));return Object(c.jsx)("div",{className:"classMetrics",children:Object(c.jsx)("div",{className:"container-fluid",children:Object(c.jsxs)("div",{className:"row",children:[Object(c.jsx)("div",{className:"left-menu col-md-2 col-xl-2 col-sm-12 col-xs-12 bd-sidebar2 d-none d-sm-none d-md-block d-lg-block d-xl-block",children:Object(c.jsx)(g,{metricsData:this.props.metricsData})}),Object(c.jsx)("div",{className:"col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none",children:Object(c.jsx)(k,{metricsData:this.props.metricsData})}),Object(c.jsxs)("div",{className:"metrics-summary col-xl-10 col-md-10 col-sm-12 col-xs-12 mt-2",children:[Object(c.jsx)("nav",{"aria-label":"breadcrumb",children:Object(c.jsx)("ol",{className:"breadcrumb",children:Object(c.jsx)("li",{className:"breadcrumb-item","aria-current":"page",children:Object(c.jsx)("a",{href:"/dashboard",children:"Back to Summary"})})})}),Object(c.jsx)(N,{name:"Class: "+this.props.classMetrics.className}),Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"info-circle"}),"\xa0Here are the individual metrics for each class below. Feedback is available below for each metric on the classes available."]}),Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsx)("h5",{children:"Metrics Legend"}),Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"thumbs-up"})," - Metric meet standards for CK Metrics Recommendations"]}),Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"thumbs-down"})," - DOES NOT Metric meet standards for CK Metrics Recommendations"]})]}),Object(c.jsxs)("div",{className:"row",children:[Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsx)("div",{className:"card",children:Object(c.jsx)("div",{className:"card-body",children:Object(c.jsxs)("div",{children:[Object(c.jsx)("h2",{children:"DIT (Depth of Inheritance)"}),Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:4,oneNum:!0,num:t.dit.value}),"\xa0 Results for DIT"]}),Object(c.jsxs)("p",{children:["The Depth of inheritance measures the maximum number of steps from the class node to the root of the inheritance. Your value is ",t.dit.value,"."]})]}),e]})})})}),Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsx)("div",{className:"card",children:Object(c.jsx)("div",{className:"card-body",children:Object(c.jsxs)("div",{children:[Object(c.jsx)("h2",{children:"WMC (Weighted methods per class)"}),Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:4,oneNum:!0,num:t.wmc.value}),"\xa0 Results for WMC"]}),Object(c.jsxs)("p",{children:["WMC measures the complexity of a class. Complexity of a class can for example be calculated by the cyclomatic complexities of its methods. Smaller values are better for WMC. Your value is ",t.wmc.value," with ",t.wmc.numberOfConstructors," constructors."]})]}),Object(c.jsx)(M,{title:"Number of Methods",metricsData:a})]})})})}),Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsx)("div",{className:"card",children:Object(c.jsxs)("div",{className:"card-body",children:[Object(c.jsx)("h2",{children:"NOF (Number of Fields)"}),Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:4,oneNum:!0,num:0}),"\xa0 Results for NOF"]}),Object(c.jsx)("p",{children:"The number of fields show the total methods for the class."})]}),Object(c.jsx)(M,{title:"NOF Metrics",metricsData:r})]})})}),Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsx)("div",{className:"card",children:Object(c.jsxs)("div",{className:"card-body",children:[Object(c.jsx)("h2",{children:"RFC (Response for a Class)"}),Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:50,oneNum:!0,num:t.rfc.total}),"\xa0 Results for RFC"]}),Object(c.jsxs)("p",{children:["RFC is defined as a count of the set of methods that can be potentially executed in response to a message received by an instance of the class. The Total RFC is ",t.rfc.total,". The RFC value is typically between 0 to 50 depending on the project."]})]}),Object(c.jsx)(M,{title:"RFC",metricsData:n})]})})}),Object(c.jsx)("div",{className:"col-lg-6 col-md-6 col-sm-12",children:Object(c.jsx)("div",{className:"card",children:Object(c.jsxs)("div",{className:"card-body",children:[Object(c.jsx)("h2",{children:"Interfaces for Class"}),Object(c.jsxs)("div",{className:"alert alert-secondary",role:"alert",children:[Object(c.jsxs)("b",{children:[Object(c.jsx)(D,{r1:0,r2:10,oneNum:!0,num:t.interfaces.numberOfInterfacesImplemented}),"\xa0 Results for RFC"]}),Object(c.jsxs)("p",{children:["RFC is defined as a count of the set of methods that can be potentially executed in response to a message received by an instance of the class. The Total RFC is ",t.rfc.total,". The RFC value is typically between 0 to 50 depending on the project."]})]}),Object(c.jsx)(M,{title:"Interfaces",metricsData:i})]})})})]})]})]})})})}return Object(c.jsx)("div",{children:"Loading..."})}}]),s}(a.Component),R=function(e){Object(d.a)(s,e);var t=Object(j.a)(s);function s(){var e;return Object(l.a)(this,s),(e=t.call(this)).state={metricsData:{summary:{},classes:[]}},e}return Object(o.a)(s,[{key:"componentDidMount",value:function(){var e=this;fetch("".concat("","/results.json")).then((function(e){return e.json()})).then((function(t){e.setState({metricsData:t})}))}},{key:"render",value:function(){var e=this;return Object(c.jsxs)(m.a,{children:[Object(c.jsx)(f,{}),Object(c.jsxs)(b.c,{children:[Object(c.jsx)(b.a,{exact:!0,path:"/",children:Object(c.jsx)("div",{className:"container",children:Object(c.jsxs)("div",{className:"row",children:[Object(c.jsx)("div",{className:"col-md-12 col-sm-12 topDiv",children:Object(c.jsx)("img",{className:"upload-logo img-fluid mx-auto d-block",src:"/images/logo-sm-horizontal.png"})}),Object(c.jsx)("div",{className:"col-md-12 col-sm-12",children:Object(c.jsx)("div",{className:"alert alert-secondary",role:"alert",children:Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"info-circle"}),"\xa0Meta Metrics Software will showcase information about the quality of your application. Please click ",Object(c.jsx)("b",{children:"View Results"})," to see feedback information."]})})}),Object(c.jsx)("div",{className:"col-md-12 col-sm-12 mx-auto button-container",children:Object(c.jsxs)("a",{className:"btn btn-primary btn-lg upload-button",href:"/dashboard",role:"button",children:[Object(c.jsx)(h.a,{icon:"chart-bar"}),"\xa0 View Results"]})})]})})}),Object(c.jsx)(b.a,{path:"/dashboard",children:Object(c.jsx)("div",{className:"container-fluid",children:Object(c.jsxs)("div",{className:"row",children:[Object(c.jsx)("div",{className:"left-menu col-md-2 col-xl-2 col-sm-12 col-xs-12 bd-sidebar d-none d-sm-none d-md-block d-lg-block d-xl-block",children:Object(c.jsx)(g,{metricsData:this.state.metricsData})}),Object(c.jsx)("div",{className:"col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none",children:Object(c.jsx)(k,{metricsData:this.state.metricsData})}),Object(c.jsxs)("div",{className:"metrics-summary col-xl-10 col-md-10 col-sm-12 col-xs-12",children:[Object(c.jsx)(v,{}),Object(c.jsx)(N,{name:"Metrics Summary"}),Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"info-circle"}),"\xa0Metrics Summary for store application"]}),Object(c.jsxs)("div",{className:"row",children:[Object(c.jsx)("div",{className:"col-xl-12 col-md-12 col-sm-12 col-xs-12",children:Object(c.jsxs)("div",{className:"alert alert-secondary text-center",role:"alert",children:[Object(c.jsx)("h5",{children:"Metrics Summary Legend"}),Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"thumbs-up"})," - Metric meet standards for CK Metrics Recommendations"]}),Object(c.jsxs)("p",{children:[Object(c.jsx)(h.a,{icon:"thumbs-down"})," - DOES NOT Metric meet standards for CK Metrics Recommendations"]})]})}),Object(c.jsx)(C,{metricsData:this.state.metricsData})]})]})]})})}),Object(c.jsx)(b.a,{path:"/metrics/classes/:id",render:function(t){var s=t.match;return Object(c.jsx)(F,{metricsData:e.state.metricsData,classMetrics:e.state.metricsData.classes[s.params.id]})}})]})]})}}]),s}(r.a.Component),T=function(e){e&&e instanceof Function&&s.e(3).then(s.bind(null,393)).then((function(t){var s=t.getCLS,c=t.getFID,a=t.getFCP,r=t.getLCP,n=t.getTTFB;s(e),c(e),a(e),r(e),n(e)}))},I=(s(387),s(388),s(47)),S=s(17);I.b.add(S.e,S.g,S.f,S.b,S.l,S.a,S.d,S.c,S.k,S.j,S.h,S.i),i.a.render(Object(c.jsx)(r.a.StrictMode,{children:Object(c.jsx)(R,{})}),document.getElementById("root")),T()}},[[391,1,2]]]);
//# sourceMappingURL=main.ec380fca.chunk.js.map