import React, { Component } from 'react';


class Navigation extends Component{
	render(){
		return(
			<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="/">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/dashboard">Dashboard</a>
  </li>
</ul>
		);
	}
}

export default Navigation;