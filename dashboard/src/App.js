import React, {useState,useEffect} from 'react';
import './App.css';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  useParams
} from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import PieCharts from './components/PieCharts/PieCharts';
import BarCharts from './components/BarCharts/BarCharts';
import Navigation from './components/Navigation/Navigation';
import Breadcrumbs from './components/Breadcrumbs/Breadcrumbs';
import LargeTitle from './components/LargeTitle/LargeTitle';
import Texts from './components/Texts/Texts';
import MetricsAll from './components/MetricsAll/MetricsAll';
import Summary from './components/Summary/Summary';
import ClassMetrics from './components/ClassMetrics/ClassMetrics';
import MobileMetricsMenu from './components/MobileMetricsMenu/MobileMetricsMenu';

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      metricsData: {summary: {}, classes: []}
    }
  }

  componentDidMount() {
    fetch(`${process.env.PUBLIC_URL}/results.json`)
      .then((r) => r.json())
      .then((data) => {
        //console.log(data);
        this.setState({'metricsData': data});
        //console.log('state:', this.state.metricsData);
      });
  }

  render(){
    
    return (
      <Router>
      <Navigation/>
      <Switch>
        <Route exact path="/">
          <div className="container">
            <div className="row">
              <div className="col-md-12 col-sm-12 topDiv">
                <img className="upload-logo img-fluid mx-auto d-block" src={process.env.PUBLIC_URL + '/images/logo-sm-horizontal.png'} /> 
              </div>
              <div className="col-md-12 col-sm-12">
              <div className="alert alert-secondary" role="alert">
                <p><FontAwesomeIcon icon="info-circle" />&nbsp;Meta Metrics Software will showcase information about the quality of your application. Please click <b>View Results</b> to see feedback information.</p> 
              </div>
              </div>
              <div className="col-md-12 col-sm-12 mx-auto button-container">
                 <a className="btn btn-primary btn-lg upload-button" href="/dashboard" role="button"><FontAwesomeIcon icon="chart-bar" />&nbsp; View Results</a>
              </div>
            </div>
          </div>
        </Route>
        <Route path="/dashboard">
          <div className="container-fluid">
            <div className="row">
              <div className="left-menu col-md-2 col-xl-2 col-sm-12 col-xs-12 bd-sidebar d-none d-sm-none d-md-block d-lg-block d-xl-block">
                <MetricsAll metricsData={this.state.metricsData}/>
              </div>
              <div className="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                <MobileMetricsMenu metricsData={this.state.metricsData} />
              </div>
              <div className="metrics-summary col-xl-10 col-md-10 col-sm-12 col-xs-12">
                <Breadcrumbs />
                <LargeTitle name="Metrics Summary"/>
                <p><FontAwesomeIcon icon="info-circle" />&nbsp;Metrics Summary for store application</p>
                
                <div className="row">
                <div className="col-xl-12 col-md-12 col-sm-12 col-xs-12">
                <div className="alert alert-secondary text-center" role="alert">
                         <h5>Metrics Summary Legend</h5>
                         <p><FontAwesomeIcon icon="thumbs-up" /> - Metric meet standards for CK Metrics Recommendations</p>
                         <p><FontAwesomeIcon icon="thumbs-down" /> - DOES NOT Metric meet standards for CK Metrics Recommendations</p>
               </div>
               </div>
                    <Summary metricsData={this.state.metricsData} />
                  </div>
              </div>
            </div>
          </div>
        </Route>
        <Route path="/metrics/classes/:id" render={({match}) => (
          <ClassMetrics metricsData={this.state.metricsData} classMetrics={this.state.metricsData.classes[match.params.id]} />
        )}>
    </Route>
      </Switch>
      </Router>
  );
  }


}

export default App;
