class CreateBlocks < ActiveRecord::Migration
  def change
    create_table :blocks do |t|
      t.integer :NoBloque
      t.text :InfoBloque
      t.integer :IdBloque

      t.timestamps null: false
    end
  end
end
