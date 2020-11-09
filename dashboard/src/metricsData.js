const metricsData = {
  "summary": {
    "pathToSrc": "C:/Projects/theProject/src",
    "pathToBin": "C:/Projects/theProject/src",
    "loc": 1909,
    "numberOfFiles": 5,
    "numberOfClasses": 5,
    "numberOfInterfaceImplementations": 2,
    "avgDit": 0.12,
    "avgWmc": 7,
    "avgNumFields": 5,
    "avgRFC": 12
  },
  "classes": [
    {
      "className": "main.TestClass",
      "dit": {
        "value": 2,
        "ancestors": [
          "main.Grandparent",
          "main.Parent"
        ]
      },
      "wmc": {
        "value": 5,
        "numberOfConstructors": 1,
        "numberOfMethods": {
          "totalMethods": 4,
          "privateMethods": 0,
          "protectedMethods": 0,
          "publicMethods": 4,
          "staticMethods": 1
        }
      },
      "numFields": {
        "totalFields": 4,
        "privateFields": 4,
        "protectedFields": 0,
        "publicFields": 0,
        "staticFields": 1
      },
      "rfc": {
        "total": 5,
        "methodsFromCurrentClass": 2,
        "methodsFromFieldObjects": 3,
        "numberOfFieldObjects": 1
      },
      "interfaces": {
        "numberOfInterfacesImplemented": 1,
        "interfacesImplemented": [
          "main.InterfaceA"
        ]
      }
    },
    {
      "className": "main.Parent",
      "dit": {
        "value": 1,
        "ancestors": [
          "main.Grandparent"
        ]
      },
      "wmc": {
        "value": 5,
        "numberOfConstructors": 1,
        "numberOfMethods": {
          "totalMethods": 4,
          "privateMethods": 0,
          "protectedMethods": 0,
          "publicMethods": 4,
          "staticMethods": 1
        }
      },
      "numFields": {
        "totalFields": 4,
        "privateFields": 4,
        "protectedFields": 0,
        "publicFields": 0,
        "staticFields": 1
      },
      "rfc": {
        "total": 5,
        "methodsFromCurrentClass": 2,
        "methodsFromFieldObjects": 3,
        "numberOfFieldObjects": 1
      },
      "interfaces": {
        "numberOfInterfacesImplemented": 1,
        "interfacesImplemented": [
          "main.InterfaceA"
        ]
      }
    },
    {
      "className": "main.Grandparent",
      "dit": {
        "value": 0,
        "ancestors": []
      },
      "wmc": {
        "value": 5,
        "numberOfConstructors": 1,
        "numberOfMethods": {
          "totalMethods": 4,
          "privateMethods": 0,
          "protectedMethods": 0,
          "publicMethods": 4,
          "staticMethods": 1
        }
      },
      "numFields": {
        "totalFields": 4,
        "privateFields": 4,
        "protectedFields": 0,
        "publicFields": 0,
        "staticFields": 1
      },
      "rfc": {
        "total": 5,
        "methodsFromCurrentClass": 2,
        "methodsFromFieldObjects": 3,
        "numberOfFieldObjects": 1
      },
      "interfaces": {
        "numberOfInterfacesImplemented": 1,
        "interfacesImplemented": [
          "main.InterfaceA"
        ]
      }
    },
    {
      "className": "main.Sibling",
      "dit": {
        "value": 0,
        "ancestors": []
      },
      "wmc": {
        "value": 5,
        "numberOfConstructors": 1,
        "numberOfMethods": {
          "totalMethods": 4,
          "privateMethods": 0,
          "protectedMethods": 0,
          "publicMethods": 4,
          "staticMethods": 1
        }
      },
      "numFields": {
        "totalFields": 4,
        "privateFields": 4,
        "protectedFields": 0,
        "publicFields": 0,
        "staticFields": 1
      },
      "rfc": {
        "total": 5,
        "methodsFromCurrentClass": 2,
        "methodsFromFieldObjects": 3,
        "numberOfFieldObjects": 1
      },
      "interfaces": {
        "numberOfInterfacesImplemented": 1,
        "interfacesImplemented": [
          "main.InterfaceA"
        ]
      }
    },
    {
      "className": "other.Other",
      "dit": {
        "value": 0,
        "ancestors": []
      },
      "wmc": {
        "value": 5,
        "numberOfConstructors": 1,
        "numberOfMethods": {
          "totalMethods": 4,
          "privateMethods": 0,
          "protectedMethods": 0,
          "publicMethods": 4,
          "staticMethods": 1
        }
      },
      "numFields": {
        "totalFields": 4,
        "privateFields": 4,
        "protectedFields": 0,
        "publicFields": 0,
        "staticFields": 1
      },
      "rfc": {
        "total": 5,
        "methodsFromCurrentClass": 2,
        "methodsFromFieldObjects": 3,
        "numberOfFieldObjects": 1
      },
      "interfaces": {
        "numberOfInterfacesImplemented": 1,
        "interfacesImplemented": [
          "main.InterfaceA"
        ]
      }
    }
  ]
};

export default metricsData;