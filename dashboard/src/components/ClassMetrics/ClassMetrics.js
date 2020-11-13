import React, { Component } from 'react';
import MetricsAll from '../MetricsAll/MetricsAll';
import MobileMetricsMenu from '../MobileMetricsMenu/MobileMetricsMenu';
import Breadcrumbs from '../Breadcrumbs/Breadcrumbs';
import LargeTitle from '../LargeTitle/LargeTitle';
import Texts from '../Texts/Texts';
import Summary from '../Summary/Summary';
import PieCharts from '../PieCharts/PieCharts';
import BarCharts from '../BarCharts/BarCharts';
import SimplePieChart from '../SimplePieChart/SimplePieChart';


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

            console.log(wmc);

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
                  <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                   <LargeTitle name={this.props.classMetrics.className}/>
                   <div className="row">
                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>DIT</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <Texts text={"DIT Value: "+metrics.dit.value}/>
                                </div>
                                
                                <PieCharts title="Ancestors" dataForChart={ancestors}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>WMC</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <Texts text={"WMC Value: "+metrics.wmc.value}/>
                                    <Texts text={"# of Constructors: "+metrics.wmc.numberOfConstructors}/>
                                </div>
                                
                                <SimplePieChart title="Number of Methods" metricsData={wmc}/>
                             </div>
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
                    No Class Found... 
                </div>
            )
        }
    }
}

export default ClassMetrics;