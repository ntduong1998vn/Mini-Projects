<?php

namespace Tests\Browser;

use Illuminate\Foundation\Testing\DatabaseMigrations;
use Laravel\Dusk\Browser;
use Tests\DuskTestCase;

class ExampleTest extends DuskTestCase
{
    /**
     * A basic browser test example.
     *
     * @return void
     */
    public function testBasicExample()
    {
        $this->browse(function (Browser $browser) {
            try {
                $browser->visit('http://www.pocha-kanazawa.com/')
                    ->pause(1000)
                    ->screenshot('screenshot');
            }catch(\FaceBook\WebDriver\Exception\TimeoutException $e){
                $browser->driver->executeScript("window.stop()");
                $browser->driver->takeScreenshot("Hello");
            }

//             Unfortunantly 'eager' mode will just be available after Chrome's version 77

// Until this you can wait for the page readyStage property as a workaround

// page.execute_script('return document.readyState') == 'interactive'
            catch (\Facebook\WebDriver\Exception\UnexpectedAlertOpenException $e) {
                // $browser->visit('http://e-honey.jp/g/')
                //     ->waitForDialog()
                //     ->acceptDialog()
                //     ->pause(2000)
                //     ->screenshot('デリバリーヘルス　ハニー　沼津　御殿場');
                $browser->visit('http://e-honey.jp/g/');
                $browser->driver->switchTo()->alert()->accept();
                $browser->pause(5000)->screenshot("Hello");
            } catch (\Throwable $th) {
                throw $th;
            }
        });
    }
}
