import React, { Component } from 'react';
import './ClassMetrics.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import MetricsAll from '../MetricsAll/MetricsAll';
import MobileMetricsMenu from '../MobileMetricsMenu/MobileMetricsMenu';
import Breadcrumbs from '../Breadcrumbs/Breadcrumbs';
import LargeTitle from '../LargeTitle/LargeTitle';
import Texts from '../Texts/Texts';
import Summary from '../Summary/Summary';
import PieCharts from '../PieCharts/PieCharts';
import BarCharts from '../BarCharts/BarCharts';
import SimplePieChart from '../SimplePieChart/SimplePieChart';
import Rating from '../Rating/Rating';


class ClassMetrics extends Component {
    render() {
        if (this.props.classMetrics) {
            const metrics = this.props.classMetrics;

            // ancestors for DIT
            const ancestors = metrics.dit.ancestors.map((k, v) => {
                return {name: k, value: 1};
            });

            // wmc
            const wmc = Object.keys(metrics.wmc.numberOfMethods).map((k,v) => {
                 return {name: k +" - "+metrics.wmc.numberOfMethods[k], value: metrics.wmc.numberOfMethods[k]};
            });

            //num of fields
            const nof = Object.keys(metrics.numFields).map((k,v) => {
                 return {name: k +" - "+metrics.numFields[k], value: metrics.numFields[k]};
            });

            // rfc
            const rfc = Object.keys(metrics.rfc).map((k,v) => {
                 return {name: k +" - "+metrics.rfc[k], value: metrics.rfc[k]};
            });

            // interfaces
            const ifc = Object.keys(metrics.interfaces).map((k,v) => {
                 return {name: k +" - "+metrics.interfaces[k], value: metrics.interfaces[k] + 0.0001};
            });

            return (
                <div>  
                   <div className="container-fluid">
               <div className="row">
                  <div className="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar2 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                    <MetricsAll metricsData={this.props.metricsData}/>
                  </div>
                  <div className="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                    <MobileMetricsMenu metricsData={this.props.metricsData} />
                  </div>
                  <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12 mt-3">
                   <LargeTitle name={"Class: "+this.props.classMetrics.className}/>
                   <p><FontAwesomeIcon icon="info-circle" />&nbsp;Here are the individual metrics for each class below. Feedback is available below for each metric on the classes available.</p>
                   <div className="alert alert-secondary" role="alert">
                         <h5>Metrics Legend</h5>
                         <p><FontAwesomeIcon icon="thumbs-up" /> - Metric meet standards for CK Metrics Recommendations</p>
                         <p><FontAwesomeIcon icon="thumbs-down" /> - DOES NOT Metric meet standards for CK Metrics Recommendations</p>
                    </div>
                   <div className="row">
                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>DIT (Depth of Inheritance)</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={4} oneNum={true} num={metrics.dit.value} />&nbsp; Results for DIT</b>
                                    <p>The Depth of inheritance measures the maximum number of steps from the class node to the root of the inheritance. Your value is {metrics.dit.value}.</p>
                                </div>
                                <SimplePieChart title="Ancestors" metricsData={ancestors}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>WMC (Weighted methods per class)</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={4} oneNum={true} num={metrics.wmc.value} />&nbsp; Results for WMC</b>
                                    <p>WMC measures the complexity of a class. Complexity of a class can for example be calculated by the cyclomatic complexities of its methods. Smaller values are better for WMC. Your value is {metrics.wmc.value} with {metrics.wmc.numberOfConstructors} constructors.</p>
                                </div>
                                
                                <SimplePieChart title="Number of Methods" metricsData={wmc}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                        <h2>NOF (Number of Fields)</h2>
                              <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={4} oneNum={true} num={0} />&nbsp; Results for NOF</b>
                                    <p>The number of fields show the total methods for the class.</p>
                             </div>

                                <SimplePieChart title="NOF Metrics" metricsData={nof}/>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <h2>RFC (Response for a Class)</h2>
                              <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={50} oneNum={true} num={metrics.rfc.total} />&nbsp; Results for RFC</b>
                                    <p>RFC is defined as a count of the set of methods that can be potentially executed in response to a message received by an instance of the class. The Total RFC is {metrics.rfc.total}. The RFC value is typically between 0 to 50 depending on the project.</p>
                             </div>
                            <SimplePieChart title="RFC" metricsData={rfc}/>
                             
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                        <h2>Interfaces for Class</h2>
                              <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={10} oneNum={true} num={metrics.interfaces.numberOfInterfacesImplemented} />&nbsp; Results for RFC</b>
                                    <p>RFC is defined as a count of the set of methods that can be potentially executed in response to a message received by an instance of the class. The Total RFC is {metrics.rfc.total}. The RFC value is typically between 0 to 50 depending on the project.</p>
                             </div>
                                <SimplePieChart title="Interfaces" metricsData={ifc}/>
                        </div>
                        </div>
                   </div>

                  </div>
                  </div>
               </div>
            </div>
                </div>
            )
        } else {
            return (
                <div>
                    Loading... 
                </div>
            )
        }
    }
}

export default ClassMetrics;