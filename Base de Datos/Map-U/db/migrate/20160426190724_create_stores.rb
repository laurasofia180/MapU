class CreateStores < ActiveRecord::Migration
  def change
    create_table :stores do |t|
      t.integer :IdLocales

      t.timestamps null: false
    end
  end
end
