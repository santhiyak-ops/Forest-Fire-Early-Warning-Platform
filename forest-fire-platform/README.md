# Forest Fire Early Warning & Ranger Dispatch Coordination Platform

Spring Boot + MySQL backend for the project requirements provided.

## Main workflow

Sensor telemetry -> automatic fire-risk check -> fire alarm -> ranger dispatch -> expenses/budget -> reports.

Fire alarm rule:
- smoke > 50 ppm AND temperature > 45 C
- creates a HIGH, ACTIVE fire alarm automatically.

## Setup

1. Make sure the `MySQL80` service is running. Create the database if it does not already exist:

```sql
CREATE DATABASE forest_fire_db;
```

2. In PowerShell, prompt for the MySQL credentials. Use the account that is configured in MySQL; for another account, replace `root` with its username:

```powershell
$mysql = Get-Credential -UserName 'root' -Message 'Enter your MySQL credentials'
$env:DB_USERNAME = $mysql.UserName
$env:DB_PASSWORD = $mysql.GetNetworkCredential().Password
```

3. Start the application in that same terminal:

```powershell
mvnw.cmd spring-boot:run
```

Do not commit your real database password. If MySQL still reports `Access denied`, verify the username and password by logging into MySQL with that account.

Server: `http://localhost:8080`

## Main APIs

### Forest sectors
POST `/api/forest/sectors`
GET `/api/forest/sectors`
GET `/api/forest/sectors/{id}`
PUT `/api/forest/sectors/{id}`
DELETE `/api/forest/sectors/{id}`

Example:
```json
{
  "sectorName": "Sector 9 High-Risk Reserve",
  "location": "Pollachi Forest",
  "riskLevel": "HIGH",
  "annualBudget": 1000000
}
```

### Telemetry
POST `/api/forest/telemetry`
GET `/api/forest/telemetry`

Example:
```json
{
  "sensorId": "S001",
  "sectorId": 1,
  "temperature": 48,
  "smokeLevel": 65,
  "humidity": 30
}
```

The above example automatically creates a HIGH fire alarm.

### Alarms
GET `/api/forest/alarms`
GET `/api/forest/alarms/active`
PUT `/api/forest/alarms/{id}/resolve`

### Ranger teams
POST `/api/forest/rangers`
GET `/api/forest/rangers`

### Dispatches
POST `/api/forest/dispatches`
GET `/api/forest/dispatches`
PUT `/api/forest/dispatches/{id}/status`

### Master/financial modules
- `/api/forest/vendors`
- `/api/forest/products`
- `/api/forest/purchase-orders`
- `/api/forest/purchase-order-items`
- `/api/forest/vendor-bills`
- `/api/forest/payments`
- `/api/forest/grants`
- `/api/forest/budgets`
- `/api/forest/chart-of-accounts`
- `/api/forest/journals`
- `/api/forest/journal-entries`

### Reports
GET `/api/reports/sector-budget`
GET `/api/reports/profit-loss`
GET `/api/reports/balance-sheet`

## Important

The project is intentionally kept as a straightforward academic MVP. Entity IDs are used for related records to keep the first version easy to understand. Foreign-key relationships and Spring Security role-based login can be added as the next enhancement.

## Modern Web UI
The project now includes a responsive dashboard under `src/main/resources/static/`.
Run the Spring Boot application and open `http://localhost:8080/` in a browser. The UI uses the existing REST APIs for sectors, telemetry, alarms, ranger teams, dispatches, vendors, purchase orders, grants, budgets and reports.
