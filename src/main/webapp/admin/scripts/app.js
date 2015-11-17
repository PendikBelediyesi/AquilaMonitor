"use strict";
angular.module("sbAdminApp", ["oc.lazyLoad", "ui.router", "ui.bootstrap", "angular-loading-bar", "ui-notification"]).config(["$stateProvider", "$urlRouterProvider", "$ocLazyLoadProvider", function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider) {
    $ocLazyLoadProvider.config({
        debug: !1,
        events: !0
    }), $urlRouterProvider.otherwise("/login"), $stateProvider.state("dashboard", {
        url: "/dashboard",
        templateUrl: "views/dashboard/main.html",
        resolve: {
            loadMyDirectives: function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: "sbAdminApp",
                    files: ["scripts/directives/header/header.js", "scripts/directives/delete/delete.js", "scripts/directives/header/header-notification/header-notification.js", "scripts/directives/sidebar/sidebar.js", "scripts/directives/sidebar/sidebar-search/sidebar-search.js"]
                }), $ocLazyLoad.load({
                    name: "toggle-switch",
                    files: ["bower_components/angular-toggle-switch/angular-toggle-switch.min.js", "bower_components/angular-toggle-switch/angular-toggle-switch.css"]
                }), $ocLazyLoad.load({
                    name: "ngAnimate",
                    files: ["bower_components/angular-animate/angular-animate.js"]
                })
            }
        }
    }).state("dashboard.home", {
        url: "/home",
        controller: "MainCtrl",
        templateUrl: "views/dashboard/home.html",
        resolve: {
            loadMyFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: "sbAdminApp",
                    files: ["scripts/controllers/main.js", "scripts/directives/timeline/timeline.js", "scripts/directives/notifications/notifications.js", "scripts/directives/chat/chat.js", "scripts/directives/dashboard/stats/stats.js"]
                })
            }
        }
    }).state("dashboard.form", {
        templateUrl: "views/form.html",
        url: "/form"
    }).state("dashboard.blank", {
        templateUrl: "views/pages/blank.html",
        url: "/blank"
    }).state("error", {
        url: "/error",
        templateUrl: "error.html",
        resolve: {
            loadMyFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: "sbAdminApp",
                    files: ["scripts/controllers/error.js"]
                })
            }
        }
    }).state("login", {
        templateUrl: "login.html",
        url: "/login",
        resolve: {
            loadMyFiles: function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: "sbAdminApp",
                    files: ["scripts/controllers/login.js", "scripts/factories/settings/userFactory.js"]
                })
            }
        }
    }).state("dashboard.chart", {
        templateUrl: "views/chart.html",
        url: "/chart",
        controller: "ChartCtrl",
        resolve: {
            loadMyFile: function ($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: "chart.js",
                    files: ["bower_components/angular-chart.js/dist/angular-chart.min.js", "bower_components/angular-chart.js/dist/angular-chart.css"]
                }), $ocLazyLoad.load({name: "sbAdminApp", files: ["scripts/controllers/chartContoller.js"]})
            }
        }
    }).state("dashboard.table", {
        templateUrl: "views/table.html",
        url: "/table"
    }).state("dashboard.panels-wells", {
        templateUrl: "views/ui-elements/panels-wells.html",
        url: "/panels-wells"
    }).state("dashboard.buttons", {
        templateUrl: "views/ui-elements/buttons.html",
        url: "/buttons"
    }).state("dashboard.notifications", {
        templateUrl: "views/ui-elements/notifications.html",
        url: "/notifications"
    }).state("dashboard.typography", {
        templateUrl: "views/ui-elements/typography.html",
        url: "/typography"
    }).state("dashboard.icons", {
        templateUrl: "views/ui-elements/icons.html",
        url: "/icons"
    }).state("dashboard.grid", {
        templateUrl: "views/ui-elements/grid.html", url: "/grid"
    })


        .state("dashboard.applicationtype", {
            templateUrl: "views/maindata/applicationtype.html",
            url: "/applicationtype",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/applicationTypeController.js", "scripts/factories/maindata/applicationTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.applicationtype_edit", {
            templateUrl: "views/maindata/applicationtype.edit.html",
            url: "/applicationtype_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/applicationTypeEditController.js", "scripts/factories/maindata/applicationTypeFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.applicationtype_add", {
            templateUrl: "views/maindata/applicationtype.edit.html",
            url: "/applicationtype_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/applicationTypeEditController.js", "scripts/factories/maindata/applicationTypeFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.ipaddress", {
            templateUrl: "views/maindata/ipaddress.html",
            url: "/ipaddress",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/ipAddressController.js", "scripts/factories/maindata/ipAddressFactory.js"]
                    })
                }
            }
        }).state("dashboard.ipaddress_edit", {
            templateUrl: "views/maindata/ipaddress.edit.html",
            url: "/ipaddress_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/ipAddressEditController.js", "scripts/factories/maindata/ipAddressFactory.js"]
                    })
                }
            }
        }).state("dashboard.ipaddress_add", {
            templateUrl: "views/maindata/ipaddress.edit.html",
            url: "/ipaddress_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/ipAddressEditController.js", "scripts/factories/maindata/ipAddressFactory.js"]
                    })
                }
            }
        }).state("dashboard.os", {
            templateUrl: "views/maindata/os.html",
            url: "/os",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/osController.js", "scripts/factories/maindata/osFactory.js"]
                    })
                }
            }
        }).state("dashboard.os_add", {
            templateUrl: "views/maindata/os.edit.html",
            url: "/os_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/osEditController.js", "scripts/factories/maindata/osFactory.js"]
                    })
                }
            }
        }).state("dashboard.os_edit", {
            templateUrl: "views/maindata/os.edit.html",
            url: "/os_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/osEditController.js", "scripts/factories/maindata/osFactory.js"]
                    })
                }
            }
        }).state("dashboard.program", {
            templateUrl: "views/maindata/program.html",
            url: "/program",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/programController.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        }).state("dashboard.program_edit", {
            templateUrl: "views/maindata/program.edit.html",
            url: "/program_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/programEditController.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        }).state("dashboard.program_add", {
            templateUrl: "views/maindata/program.edit.html",
            url: "/program_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/programEditController.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        }).state("dashboard.relationtype", {
            templateUrl: "views/maindata/relationtype.html",
            url: "/relationtype",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/relationTypeController.js", "scripts/factories/maindata/relationTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.relationtype_edit", {
            templateUrl: "views/maindata/relationtype.edit.html",
            url: "/relationtype_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/relationTypeEditController.js", "scripts/factories/maindata/relationTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.relationtype_add", {
            templateUrl: "views/maindata/relationtype.edit.html",
            url: "/relationtype_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/relationTypeEditController.js", "scripts/factories/maindata/relationTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.servertype", {
            templateUrl: "views/maindata/servertype.html",
            url: "/servertype",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/serverTypeController.js", "scripts/factories/maindata/serverTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.servertype_edit", {
            templateUrl: "views/maindata/servertype.edit.html",
            url: "/servertype_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/serverTypeEditController.js", "scripts/factories/maindata/serverTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.servertype_add", {
            templateUrl: "views/maindata/servertype.edit.html",
            url: "/servertype_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/serverTypeEditController.js", "scripts/factories/maindata/serverTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.cputype", {
            templateUrl: "views/maindata/cputype.html",
            url: "/cputype",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/cpuTypeController.js", "scripts/factories/maindata/cpuTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.cputype_edit", {
            templateUrl: "views/maindata/cputype.edit.html",
            url: "/cputype_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/cpuTypeEditController.js", "scripts/factories/maindata/cpuTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.cputype_add", {
            templateUrl: "views/maindata/cputype.edit.html",
            url: "/cputype_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/maindata/cpuTypeEditController.js", "scripts/factories/maindata/cpuTypeFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.application", {
            templateUrl: "views/management/application.html",
            url: "/application",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/applicationController.js", "scripts/factories/management/applicationFactory.js", "scripts/factories/maindata/applicationTypeFactory.js", "scripts/factories/management/serverProgramFactory.js"]
                    })
                }
            }
        }).state("dashboard.application_edit", {
            templateUrl: "views/management/application.edit.html",
            url: "/application_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/applicationEditController.js", "scripts/factories/management/applicationFactory.js", "scripts/factories/maindata/applicationTypeFactory.js", "scripts/factories/management/serverProgramFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.application_add", {
            templateUrl: "views/management/application.edit.html",
            url: "/application_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/applicationEditController.js", "scripts/factories/management/applicationFactory.js", "scripts/factories/maindata/applicationTypeFactory.js", "scripts/factories/management/serverProgramFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.server", {
            templateUrl: "views/management/server.html",
            url: "/server",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/serverController.js", "scripts/factories/management/serverFactory.js", "scripts/factories/maindata/ipAddressFactory.js", "scripts/factories/maindata/serverTypeFactory.js", "scripts/factories/maindata/osFactory.js", "scripts/factories/maindata/programFactory.js", "scripts/factories/maindata/cpuTypeFactory.js"]
                    })
                }
            }
        }).state("dashboard.server_edit", {
            templateUrl: "views/management/server.edit.html",
            url: "/server_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/serverEditController.js", "scripts/factories/management/serverFactory.js", "scripts/factories/maindata/ipAddressFactory.js", "scripts/factories/maindata/serverTypeFactory.js", "scripts/factories/maindata/osFactory.js", "scripts/factories/maindata/programFactory.js", "scripts/factories/maindata/cpuTypeFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.server_add", {
            templateUrl: "views/management/server.edit.html",
            url: "/server_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/serverEditController.js", "scripts/factories/management/serverFactory.js", "scripts/factories/maindata/ipAddressFactory.js", "scripts/factories/maindata/serverTypeFactory.js", "scripts/factories/maindata/osFactory.js", "scripts/factories/maindata/programFactory.js", "scripts/factories/maindata/cpuTypeFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.serverprogram", {
            templateUrl: "views/management/serverprogram.html",
            url: "/serverprogram",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/serverProgramController.js", "scripts/factories/management/serverProgramFactory.js", "scripts/factories/management/serverFactory.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        }).state("dashboard.serverprogram_edit", {
            templateUrl: "views/management/serverprogram.edit.html",
            url: "/serverprogram_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/serverProgramEditController.js", "scripts/factories/management/serverProgramFactory.js", "scripts/factories/management/serverFactory.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.serverprogram_add", {
            templateUrl: "views/management/serverprogram.edit.html",
            url: "/serverprogram_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/serverProgramEditController.js", "scripts/factories/management/serverProgramFactory.js", "scripts/factories/management/serverFactory.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.responsible", {
            templateUrl: "views/management/responsible.html",
            url: "/responsible",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/responsibleController.js", "scripts/factories/management/responsibleFactory.js"]
                    })
                }
            }
        }).state("dashboard.responsible_edit", {
            templateUrl: "views/management/responsible.edit.html",
            url: "/responsible_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/responsibleEditController.js", "scripts/factories/management/responsibleFactory.js", "scripts/factories/management/serverProgramFactory.js", "scripts/factories/management/serverFactory.js", "scripts/factories/management/applicationFactory.js", "scripts/factories/settings/userFactory.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.responsible_add", {
            templateUrl: "views/management/responsible.edit.html",
            url: "/responsible_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/responsibleEditController.js", "scripts/factories/management/responsibleFactory.js", "scripts/factories/management/serverProgramFactory.js", "scripts/factories/management/serverFactory.js", "scripts/factories/management/applicationFactory.js", "scripts/factories/settings/userFactory.js", "scripts/factories/maindata/programFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.relation", {
            templateUrl: "views/management/relation.html",
            url: "/relation",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/relationController.js", "scripts/factories/management/relationFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.applicationreport", {
            templateUrl: "views/management/reports.html",
            url: "/applicationreport",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/management/applicationReportController.js", "scripts/factories/management/applicationReportFactory.js"]
                    })
                }
            }
        })


        .state("dashboard.monitor", {
            templateUrl: "views/monitor/monitor.html",
            url: "/monitor",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/monitor/monitorController.js", "scripts/factories/monitor/monitorFactory.js"]
                    })
                }
            }
        }).state("dashboard.monitor_edit", {
            templateUrl: "views/monitor/monitor.edit.html",
            url: "/monitor_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/monitor/monitorEditController.js", "scripts/factories/monitor/monitorFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.monitor_add", {
            templateUrl: "views/monitor/monitor.edit.html",
            url: "/monitor_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/monitor/monitorEditController.js", "scripts/factories/monitor/monitorFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.monitorchart", {
            templateUrl: "views/monitor/chart.html",
            url: "/monitorchart",
            resolve: {
                loadMyFile: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "chart.js",
                        files: ["bower_components/angular-chart.js/dist/angular-chart.min.js", "bower_components/angular-chart.js/dist/angular-chart.css"]
                    }), $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/monitor/monitorChartController.js", "scripts/factories/monitor/monitorChartFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.monitorreport", {
            templateUrl: "views/monitor/reports.html",
            url: "/monitorreport",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/monitor/monitorReportController.js", "scripts/factories/monitor/monitorReportFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.monitorlog", {
            templateUrl: "views/monitor/logs.html",
            url: "/monitorlog",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/monitor/monitorLogController.js", "scripts/factories/monitor/monitorLogFactory.js"]
                    })
                }
            }
        })


        .state("dashboard.parameter", {
            templateUrl: "views/settings/parameter.html",
            url: "/parameter",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/parameterController.js", "scripts/factories/settings/parameterFactory.js"]
                    })
                }
            }
        }).state("dashboard.parameter_edit", {
            templateUrl: "views/settings/parameter.edit.html",
            url: "/parameter_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/parameterEditController.js", "scripts/factories/settings/parameterFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.parameter_add", {
            templateUrl: "views/settings/parameter.edit.html",
            url: "/parameter_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/parameterEditController.js", "scripts/factories/settings/parameterFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.user", {
            templateUrl: "views/settings/user.html",
            url: "/user",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/userController.js", "scripts/factories/settings/userFactory.js", "scripts/factories/settings/roleFactory.js"]
                    })
                }
            }
        }).state("dashboard.user_edit", {
            templateUrl: "views/settings/user.edit.html",
            url: "/user_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/userEditController.js", "scripts/factories/settings/userFactory.js", "scripts/factories/settings/roleFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.user_add", {
            templateUrl: "views/settings/user.edit.html",
            url: "/user_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/userEditController.js", "scripts/factories/settings/userFactory.js", "scripts/factories/settings/roleFactory.js"]
                    })
                }
            }
        }).state("dashboard.role", {
            templateUrl: "views/settings/role.html",
            url: "/role",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/roleController.js", "scripts/factories/settings/roleFactory.js"]
                    })
                }
            }
        }).state("dashboard.role_edit", {
            templateUrl: "views/settings/role.edit.html",
            url: "/role_edit",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/roleEditController.js", "scripts/factories/settings/roleFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.role_add", {
            templateUrl: "views/settings/role.edit.html",
            url: "/role_add",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/roleEditController.js", "scripts/factories/settings/roleFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.log", {
            templateUrl: "views/settings/log.html",
            url: "/log",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/settings/logController.js", "scripts/factories/settings/logFactory.js"]
                    })
                }
            }
        })
        .state("dashboard.livestatus", {
            templateUrl: "views/livestatus.html",
            url: "/livestatus",
            resolve: {
                loadMyFiles: function ($ocLazyLoad) {
                    return $ocLazyLoad.load({
                        name: "sbAdminApp",
                        files: ["scripts/controllers/liveStatusController.js", "scripts/factories/liveStatusFactory.js"]
                    })
                }
            }
        })


}]).factory('UserService', function ($http) {

    var currentUser = null;

    var adminRoles = ['admin'];
    var otherRoles = ['user', 'editor'];
    console.log('UserService ->');

    return {
        // some code that gets and sets the user to the singleton variable...
        validateRoleAdmin: function () {
            console.log(currentUser);
            console.log(_.has(currentUser, "role") && _.contains(adminRoles, currentUser.role));
            return _.has(currentUser, "role") && _.contains(adminRoles, currentUser.role);
        },
        login: function (user) {
            console.log('UserService login ', user);
            // this method could be used to call the API and set the user instead of taking it in the function params
            currentUser = user;
        },
        logout: function () {
            console.log('UserService logout ');
            // this method could be used to call the API and set the user instead of taking it in the function params
            currentUser = null;
        },
        isLoggedIn: function () {
            console.log("AuthenticationService isLoggedIn " + angular.isDefined(currentUser) && angular.isObject(currentUser) && _.has(currentUser, "username"));
            console.log(currentUser);
            return (angular.isDefined(currentUser) && angular.isObject(currentUser) && _.has(currentUser, "username"));
        },

        validateRoleOther: function () {
            console.log(currentUser);
            console.log(_.has(currentUser, "role"));
            return _.has(currentUser, "role") && _.contains(otherRoles, currentUser.role);
        }
    };
}).run(function ($rootScope, $location, $state, UserService, Notification) {

    // enumerate routes that don't need authentication
    var routesThatDontRequireAuth = ['/login', '/error'];
    var routesThatForAdmins = ['/os', '/servertype'];
    // check if route does not require authentication
    var routeClean = function (route) {
        console.log("routeClean " + route + " State " + _.contains(routesThatDontRequireAuth, route));
        return _.contains(routesThatDontRequireAuth, route);
    };
    // check if route requires admin priviledge
    var routeAdmin = function (route) {
        console.log("routeAdmin " + route + " State " + _.contains(routesThatForAdmins, route));
        return _.contains(routesThatForAdmins, route);
    };

    $rootScope.$on('$stateChangeStart', function (ev, to, toParams, from, fromParams) {
        console.log('Run $stateChangeStart->');
        console.log("Ev ", ev);
        console.log("To ", to);
        console.log("from ", from);

        if (!routeClean(to.url) && !UserService.isLoggedIn()) {
            // redirect back to login
            console.log('Redirect To Login');
            ev.preventDefault();

            $state.go('login');
            Notification.error('Please Login first!');
            //  $location.path('login');
        }
        else if (routeAdmin(to.url) && !UserService.validateRoleAdmin()) {
            // redirect to error page
            console.log('Redirect To Error');
            ev.preventDefault();
            //  $state.go('error');
            Notification.error('You are not authorized to view this (' + to.url + ') page ! Please contact with system administrator.');
            //  $location.path('error');
        }

        console.log('Go on');
    });
});
;