# peersland
create database peerislands;
use peerislands;
CREATE TABLE item (item_id INT PRIMARY KEY AUTO_INCREMENT,item_name VARCHAR(100),price DECIMAL(10, 2),description varchar(100));
CREATE TABLE orders (order_id INT PRIMARY KEY AUTO_INCREMENT,order_status VARCHAR(50), created_time datetime, modified_time datetime);

CREATE TABLE order_item (id INT PRIMARY KEY AUTO_INCREMENT,order_id INT,item_id INT,quantity INT,
FOREIGN KEY (order_id) REFERENCES orders(order_id), FOREIGN KEY (item_id) REFERENCES item(item_id)); 

INSERT INTO Item (item_id, item_name, price, description) VALUES
(101, 'Wireless Bluetooth Headphones', 89.99, 'Noise-cancelling over-ear headphones with 20-hour battery life.'),
(102, 'Stainless Steel Chef Knife', 34.95, '8-inch professional chef knife with ergonomic handle.'),
(103, 'Moisturizing Face Cream', 24.50, 'Hydrating cream with aloe vera and vitamin E for all skin types.'),
(104, 'Smart LED TV 55-inch', 499.99, '4K Ultra HD smart TV with built-in streaming apps.'),
(105, 'Non-Stick Frying Pan', 29.99, '12-inch ceramic-coated frying pan, dishwasher safe.'),
(106, 'Matte Liquid Lipstick', 12.99, 'Long-lasting, smudge-proof lipstick in vibrant red.'),
(107, 'Portable Power Bank 10000mAh', 19.95, 'Compact power bank with fast-charging USB-C port.'),
(108, 'Electric Kettle 1.7L', 39.99, 'Stainless steel kettle with auto shut-off feature.'),
(109, 'Exfoliating Face Scrub', 15.75, 'Gentle scrub with walnut shell powder for smooth skin.'),
(110, 'Wireless Gaming Mouse', 49.99, 'Ergonomic mouse with customizable RGB lighting.'),
(111, 'Silicone Baking Mat', 14.50, 'Non-stick reusable mat for baking cookies and pastries.'),
(112, 'Eyelash Curler', 9.99, 'Precision curler with soft silicone pads for natural lift.'),
(113, 'Smart Wi-Fi Plug', 12.99, 'Control devices remotely via app or voice assistant.'),
(114, 'Cast Iron Skillet', 44.95, '10-inch pre-seasoned skillet for versatile cooking.'),
(115, 'Anti-Aging Serum', 29.99, 'Serum with retinol and hyaluronic acid for youthful skin.'),
(116, 'Bluetooth Speaker', 59.99, 'Waterproof portable speaker with 12-hour playtime.'),
(117, 'Glass Food Storage Set', 24.99, '5-piece airtight container set for meal prep.'),
(118, 'Waterproof Mascara', 11.50, 'Volumizing mascara resistant to water and smudging.'),
(119, 'USB-C Hub Adapter', 29.95, 'Multi-port adapter with HDMI, USB, and SD card slots.'),
(120, 'Air Fryer 5.5Qt', 79.99, 'Digital air fryer with 8 preset cooking modes.'),
(121, 'BB Cream SPF 30', 18.99, 'Lightweight tinted moisturizer with sun protection.'),
(122, 'Smart Thermostat', 129.99, 'Wi-Fi enabled thermostat for energy-efficient heating.'),
(123, 'Wooden Cutting Board', 19.95, 'Durable bamboo cutting board with juice groove.'),
(124, 'Nail Polish Set', 14.99, '6 vibrant colors, quick-dry formula, long-lasting.'),
(125, 'Wireless Charging Pad', 24.99, 'Fast-charging pad compatible with Qi-enabled devices.'),
(126, 'Immersion Blender', 34.99, '3-speed handheld blender for soups and smoothies.'),
(127, 'Cleansing Oil', 22.50, 'Gentle oil-based cleanser for removing makeup.'),
(128, 'Fitness Tracker', 39.99, 'Water-resistant tracker with heart rate and sleep monitoring.'),
(129, 'Slow Cooker 6Qt', 49.95, 'Programmable slow cooker with ceramic pot.'),
(130, 'Lip Balm Trio', 9.95, 'Moisturizing balms in vanilla, mint, and berry flavors.'),
(131, 'External Hard Drive 2TB', 69.99, 'Portable USB 3.0 hard drive for data backup.'),
(132, 'Kitchen Scale Digital', 16.99, 'Precision scale for measuring up to 11 lbs.'),
(133, 'Clay Face Mask', 17.99, 'Detoxifying mask with kaolin clay for deep cleansing.'),
(134, 'Smart Light Bulb', 14.99, 'Color-changing LED bulb, app-controlled.'),
(135, 'Mandoline Slicer', 29.99, 'Adjustable slicer with stainless steel blades.'),
(136, 'Highlighter Palette', 19.95, '4-shade palette for a radiant glow.'),
(137, 'Dash Cam 1080p', 59.99, 'Compact dash camera with night vision and loop recording.'),
(138, 'Toaster Oven', 64.99, 'Multi-function oven with bake, broil, and toast settings.'),
(139, 'Eyebrow Pencil', 8.99, 'Waterproof pencil with spoolie for precise application.'),
(140, 'Noise-Cancelling Earbuds', 79.99, 'True wireless earbuds with 8-hour battery life.'),
(141, 'Mixing Bowl Set', 22.95, '3-piece stainless steel bowls with non-slip bases.'),
(142, 'Sunscreen SPF 50', 13.99, 'Broad-spectrum sunscreen, non-greasy formula.'),
(143, 'Mini Projector', 89.99, 'Portable projector with HDMI and USB inputs.'),
(144, 'Coffee Maker 12-Cup', 44.95, 'Programmable drip coffee maker with glass carafe.'),
(145, 'Foundation Makeup', 21.99, 'Medium-coverage foundation in 10 shades.'),
(146, 'Robot Vacuum Cleaner', 199.99, 'Wi-Fi enabled vacuum with self-charging feature.'),
(147, 'Pizza Stone', 24.99, 'Ceramic stone for crispy, evenly baked pizza.'),
(148, 'Hair Serum', 16.50, 'Nourishing serum for frizz control and shine.'),
(149, 'Action Camera 4K', 99.99, 'Waterproof camera with wide-angle lens and accessories.'),
(150, 'Utensil Set 6-Piece', 19.99, 'Stainless steel kitchen tools with hanging rack.');





//order request
{
   "items":[
      {"item":{"itemId":140}, "quantity":20},
      {"item":{"itemId":122}, "quantity":2},
      {"item":{"itemId":127}, "quantity":30}
   ]
}
