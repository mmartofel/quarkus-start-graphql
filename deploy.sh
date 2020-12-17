 mvn clean install -Dquarkus.profile=dev
 git add .
 git commit -m $1
 git push origin main
 oc delete svc/quarkus-start-graphql
 oc delete deployment/quarkus-start-graphql
 oc delete buildconfig/quarkus-start-graphql
 oc delete imagestream/quarkus-start-graphql
 oc new-app https://github.com/mmartofel/quarkus-start-graphql.git
 oc logs -f bc/quarkus-start-graphql
