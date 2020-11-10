import React, { Component } from 'react';
import './Navigation.css';

class Navigation extends Component{
	render(){
		return(
      <div>
<nav className="navbar navbar-expand-lg navbar-light">
    <div className="d-flex flex-grow-1">
        <a className="navbar-brand" href="/">
            <img src={process.env.PUBLIC_URL + "/images/logo-symbol.png"} width="30" height="30" alt="" loading="lazy"></img> Meta Metrics
        </a>
        <div className="w-100 text-right">
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-menu">
                <span className="navbar-toggler-icon"></span>
            </button>
        </div>
    </div>
    <div className="collapse navbar-collapse flex-grow-1 text-center" id="mobile-menu">
        <ul className="navbar-nav ml-auto flex-nowrap nav-pills">
            <li className="nav-item">
                <a href="/" className="nav-link">Upload</a>
            </li>
            <li className="nav-item">
                <a href="/dashboard" className="nav-link active">Summary</a>
            </li>
            <li className="nav-item">
                <a href="/metrics" className="nav-link">Metrics</a>
            </li>
        </ul>
    </div>
</nav>
</div>
		);
	}
}

export default Navigation;