
# Set git commit comment 
COMMIT_COMMENT='Configuration change done at: '`date`

# Buld artefact
 mvn clean package

# Push code to git
 git add .
 git commit -m "$COMMIT_COMMENT"
 git push origin main
 
# Create Postgres instance 
 oc delete deployment/ratownictwo-prod
 ./postgres/create_postgres_instance.sh pg.env ratownictwo-prod

 # Create application service
 oc delete svc/quarkus-start-graphql
 oc delete deployment/quarkus-start-graphql
 oc delete buildconfig/quarkus-start-graphql
 oc delete imagestream/quarkus-start-graphql
 oc delete route/quarkus-start-graphql
 oc new-app https://github.com/mmartofel/quarkus-start-graphql.git
 oc logs -f bc/quarkus-start-graphql
 oc expose svc/quarkus-start-graphql


oc label deployment/ratownictwo-prod app.kubernetes.io/part-of=RATOWNICTWO --overwrite
oc label deployment/quarkus-start-graphql app.kubernetes.io/part-of=RATOWNICTWO --overwrite
oc label deployment/quarkus-start-graphql app.openshift.io/runtime=quarkus --overwrite

