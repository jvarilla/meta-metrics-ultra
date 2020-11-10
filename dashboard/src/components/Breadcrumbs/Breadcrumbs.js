import React, { Component } from 'react';
import './Breadcrumbs.css';

class Breadcrumbs extends Component{
	render(){
		return(
      <div>
        <nav aria-label="breadcrumb">
  <ol className="breadcrumb">
    <li className="breadcrumb-item" aria-current="page">Upload</li>
    <li className="breadcrumb-item active" aria-current="page">Metrics Summary</li>
  </ol>
</nav>
</div>
		);
	}
}

export default Breadcrumbs;