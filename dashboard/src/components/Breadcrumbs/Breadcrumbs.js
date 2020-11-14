import React, { Component } from 'react';
import './Breadcrumbs.css';

class Breadcrumbs extends Component{
	render(){
		return(
      <div>
        <nav aria-label="breadcrumb">
  <ol className="breadcrumb">
    <li className="breadcrumb-item" aria-current="page"><a href="/">Information</a></li>
    <li className="breadcrumb-item active" aria-current="page"><a href="/dashboard">Metrics Summary</a></li>
  </ol>
</nav>
</div>
		);
	}
}

export default Breadcrumbs;