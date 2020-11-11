import React, { Component } from 'react';
import './Navigation.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class Navigation extends Component{
	render(){
		return(
      <div>
<nav className="navbar navbar-expand-lg navbar-light navbar-meta">
    <div className="d-flex flex-grow-1 nav-bar-inner">
        <a className="navbar-brand" href="/">
            <img src={process.env.PUBLIC_URL + "/images/logo-symbol.png"} width="50" height="50" alt="" loading="lazy"></img>
        </a>
        <div className="w-100 text-right">
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-menu">
                <span className="navbar-toggler-icon"><FontAwesomeIcon icon="bars" /></span>
            </button>
        </div>
    </div>
    <div className="collapse navbar-collapse text-center" id="mobile-menu">
        <ul className="navbar-nav ml-auto flex-nowrap nav-pills">
            <li className="nav-item">
                <a href="/" className="nav-link"><FontAwesomeIcon icon="upload" />&nbsp; Upload</a>
            </li>
            <li className="nav-item">
                <a href="/dashboard" className="nav-link active"><FontAwesomeIcon icon="align-left" />&nbsp; Summary</a>
            </li>
            <li className="nav-item">
                <a href="/metrics" className="nav-link"><FontAwesomeIcon icon="chart-pie" />&nbsp; Metrics</a>
            </li>
        </ul>
        </div>
</nav>
</div>
		);
	}
}

export default Navigation;