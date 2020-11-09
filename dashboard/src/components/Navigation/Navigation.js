import React, { Component } from 'react';
import './Navigation.css';

class Navigation extends Component{
	render(){
		return(
      <div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="d-flex flex-grow-1">
        <a class="navbar-brand" href="/">
            <img src={process.env.PUBLIC_URL + "/images/logo-symbol.png"} width="30" height="30" alt="" loading="lazy"></img> Meta Metrics
        </a>
        <div class="w-100 text-right">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-menu">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
    <div class="collapse navbar-collapse flex-grow-1 text-center" id="mobile-menu">
        <ul class="navbar-nav ml-auto flex-nowrap nav-pills">
            <li class="nav-item">
                <a href="/" class="nav-link">Upload</a>
            </li>
            <li class="nav-item">
                <a href="/dashboard" class="nav-link active">Summary</a>
            </li>
            <li class="nav-item">
                <a href="/metrics" class="nav-link">Metrics</a>
            </li>
        </ul>
    </div>
</nav>
</div>
		);
	}
}

export default Navigation;