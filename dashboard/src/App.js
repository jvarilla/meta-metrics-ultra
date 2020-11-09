import React from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { fab } from "@fortawesome/free-brands-svg-icons";

import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams
} from "react-router-dom";
import PieCharts from './components/PieCharts/PieCharts';
import BarCharts from './components/BarCharts/BarCharts';
import metricsData from './metricsData';
import Navigation from './components/Navigation/Navigation';
import Breadcrumbs from './components/Breadcrumbs/Breadcrumbs';
import LargeTitle from './components/LargeTitle/LargeTitle';
import Texts from './components/Texts/Texts';
import MetricsAll from './components/MetricsAll/MetricsAll';

class App extends React.Component {
  render(){
    return (
      <Router>
      <Navigation/>
      <Switch>
        <Route exact path="/">
         <div class="container">
     <div class="row">
      <div class="col-md-6 col-sm-12">
          <div class="card">
              <div class="card-body">
                <PieCharts/>
              </div>
          </div>  
      </div>
      <div class="col-md-6 col-sm-12">
          <div class="card">
              <div class="card-body">
                <BarCharts/>
              </div>
          </div>
      </div>
     </div>
    </div>
   </Route>
         <Route path="/dashboard">
            <div class="container-fluid">
              <div class="row">
                 <div class="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar d-none d-sm-none d-md-block d-lg-block d-xl-block">
                  <MetricsAll/>
              </div>
              <div class="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                  <Breadcrumbs />
                  <LargeTitle name="Metrics Summary"/>
                  <Texts text="Summary for store application"/>
              </div>
              </div>
            </div>
         </Route>
        // <Route path="/dashboard/:item">
           
        // </Route>
      </Switch>
      </Router>
  );
  }


}

export default App;
