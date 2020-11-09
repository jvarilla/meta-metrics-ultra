import React, { Component } from 'react';
import './Breadcrumbs.css';

class Breadcrumbs extends Component{
	render(){
		return(
      <div>
        <nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item" aria-current="page">Upload</li>
    <li class="breadcrumb-item active" aria-current="page">Metrics Summary</li>
  </ol>
</nav>
</div>
		);
	}
}

export default Breadcrumbs;