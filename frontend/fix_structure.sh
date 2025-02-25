#!/bin/bash

# Navigate to src/app directory
cd src/app || exit

echo "Creating necessary directories..."

# Create required directories
mkdir -p components/user/user-list components/user/user-create components/user/user-login
mkdir -p components/recipe/recipe-list components/recipe/recipe-create components/recipe/recipe-detail
mkdir -p services models

echo "Moving necessary files..."

# Move services to the correct directory
mv user.service.ts services/ 2>/dev/null
mv recipe.service.ts services/ 2>/dev/null

# Move models to the correct directory
mv user.model.ts models/ 2>/dev/null
mv recipe.model.ts models/ 2>/dev/null

# Rename app.routes.ts to app-routing.module.ts if it exists
[ -f app.routes.ts ] && mv app.routes.ts app-routing.module.ts

# Remove unnecessary files
rm -f app.config.ts

# Navigate back to src
cd ..

echo "Creating global directories..."
mkdir -p assets environments

echo "Project structure has been fixed!"
