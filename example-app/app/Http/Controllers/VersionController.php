<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GrahamCampbell\Markdown\Facades\Markdown;

class VersionController extends Controller
{
    public function index()
    {
        return view("welcome");
    }
}