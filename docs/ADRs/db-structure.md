## Database Structure

Status — Accepted
Context — How to structure the tables to faciliate clearline's objective

Tenant -- The organization using clear line. Identified by a name and a unique ID.
SKU -- A product that can be ordered upon. Belongs to 1 tenant
orders -- orders on skus.
stock -- the current amount left of the skus
order lines -- how many customers have bid on a product


Decision — what you chose
Consequences — tradeoffs, follow-ups