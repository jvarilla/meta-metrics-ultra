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
        console.log('state:', this.state.metricsData);
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
              <div className="progress">
                  <div className="progress-bar w-100" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">Click Upload to View Methods</div>
              </div>
              </div>
              <div className="col-md-12 col-sm-12 mx-auto button-container">
                 <a className="btn btn-primary btn-lg upload-button" href="/dashboard" role="button"><FontAwesomeIcon icon="cloud-upload-alt" />&nbsp; Upload</a>
              </div>
            </div>
          </div>
        </Route>
        <Route path="/dashboard">
          <div className="container-fluid">
            <div className="row">
              <div className="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar d-none d-sm-none d-md-block d-lg-block d-xl-block">
                <MetricsAll metricsData={this.state.metricsData}/>
              </div>
              <div class="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                <MobileMetricsMenu metricsData={this.state.metricsData} />
              </div>
              <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                <Breadcrumbs />
                <LargeTitle name="Metrics Summary"/>
                <Texts text="Metrics Summary for store application"/>
                <div className="row">
                    <Summary metricsData={this.state.metricsData} />
                  </div>
              </div>
            </div>
          </div>
        </Route>
        <Route path="/metrics/classes/:id">
            <div className="container-fluid">
               <div className="row">
                  <div className="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar2 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                    <MetricsAll metricsData={this.state.metricsData}/>
                  </div>
                  <div className="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                    <MobileMetricsMenu metricsData={this.state.metricsData} />
                  </div>
                  <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                    <ClassMetrics metricsData={this.state.metricsData} />
                </div>
               </div>
            </div>
        </Route>
      </Switch>
      </Router>
  );
  }


}

export default App;
